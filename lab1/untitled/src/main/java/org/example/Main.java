package org.example;

import javax.persistence.*;
import java.io.*;
import java.util.*;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.Collectors;

public class Main {

    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("jpa-hibernate-example");

    public static void main(String[] args) {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        Profession profession1 = new Profession("Profession_1", 2);
        Profession profession2 = new Profession("Profession_2", 3);
        Character character1 = new Character("Character_1", 1, profession1);
        Character character2 = new Character("Character_2", 2, profession2);
        Character character3 = new Character("Character_3", 3, profession2);

        Profession[] professionArray = {profession1, profession2};
        Character[] characterArray = {character1, character2, character3};

        Arrays.stream(professionArray).forEach(entityManager::persist);
        Arrays.stream(characterArray).forEach(character -> {
            entityManager.persist(character);
            character.AddToProfession();
        });

        Arrays.stream(professionArray).forEach(entityManager::merge);
        transaction.commit();

        // Task 2
        transaction.begin();
        System.out.println("All Professions:");
        List<Profession> professions = entityManager.createQuery("SELECT p FROM Profession p", Profession.class).getResultList();
        Arrays.stream(professionArray).forEach(profession -> {
            System.out.println("Profession: " + profession.getName() + " Base Armor: " + profession.getBaseArmor() + ", characters:");
            profession.getCharacters().forEach(character -> System.out.println("- " + character.getName() + " Level: " + character.getLevel()));
        });
        transaction.commit();

        // Task 3
        Set<Profession> professionSet = professions.stream()
                .collect(Collectors.toSet());

        System.out.println("\nAll Professions( Stream api):");
        professionSet.forEach(profession ->
                System.out.println("Profession: " + profession.getName() + ", Base Armor: " + profession.getBaseArmor() + ", characters:" + profession.getCharacters())
        );

        Set<Character> characterSet = professionSet.stream()
                .flatMap(profession -> profession.getCharacters().stream())
                .collect(Collectors.toSet());
        System.out.println("\nAll Characters (Stream API):");
        characterSet.forEach(character -> System.out.println("- " + character.getName() + " Level: " + character.getLevel() + ", profession:" + character.getProfession().getName()));

        // Task 4
        System.out.println("All characters with level > 1, reverse sorted:");
        professionSet.stream()
                .flatMap(profession -> profession.getCharacters().stream())
                .filter(character -> character.getLevel() > 1)
                .sorted(Comparator.comparingInt(Character::getLevel).reversed())
                .forEach(character -> System.out.println("- " + character.getName() + " Level: " + character.getLevel()));

        // Task 5
        List<CharacterDTO> characterDtoList = professionSet.stream()
                .flatMap(profession -> profession.getCharacters().stream())
                .map(character -> new CharacterDTO(character.getName(), character.getLevel(), character.getProfession().getName()))
                .collect(Collectors.toList());
        System.out.println("Character DTO Collection:");
        characterDtoList.forEach(System.out::println);

        // Task 6
        try (ObjectOutputStream outStream = new ObjectOutputStream(new FileOutputStream("professions.dat"))) {
            outStream.writeObject(professionArray);  // Serialize professions
        } catch (IOException e) {
            e.printStackTrace();
        }

        Profession[] deserializedProfessions;
        try (ObjectInputStream inStream = new ObjectInputStream(new FileInputStream("professions.dat"))) {
            deserializedProfessions = (Profession[]) inStream.readObject();  // Deserialize professions
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Deserialized Professions and their Characters:");
        Arrays.stream(deserializedProfessions).forEach(profession -> {
            System.out.println("Profession: " + profession.getName() + " Base Armor: " + profession.getBaseArmor());
            profession.getCharacters().forEach(character -> System.out.println("- " + character.getName() + " Level: " + character.getLevel()));
        });

        // Task 7
        ForkJoinPool customThreadPool = new ForkJoinPool(4);
        try {
            customThreadPool.submit(() -> {
                Set<Profession> deserializedSet = Set.of(deserializedProfessions);
                deserializedSet.parallelStream().forEach(profession -> {
                    System.out.println("Processing Profession: " + profession.getName());
                    profession.getCharacters().forEach(character -> {
                        try {
                            Thread.sleep(500);  // Simulate work
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("Character: " + character.getName() + " Level: " + character.getLevel());
                    });
                });
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            customThreadPool.shutdown();
        }
        entityManager.close();
        entityManagerFactory.close();
    }
}
