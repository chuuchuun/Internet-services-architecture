package org.example;

public class CharacterDTO {
    private String name;
    private int level;
    private String profession;
    public CharacterDTO(String name, int level, String profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }
    @Override
    public String toString() {
        return "Character DTO: name"
                + name
                + ", level"
                + level
                + ", profession"
                + profession;
    }
}