package org.example;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Character implements Serializable {
    @Id
    private String name;
    private int level;
    @ManyToOne
    private Profession profession;

    public Character(String name, int level, Profession profession) {
        this.name = name;
        this.level = level;
        this.profession = profession;
    }
    public Character() {

    }

    public String getName() {
        return name;
    }
    public int getLevel() {
        return level;
    }
    public Profession getProfession() {
        return profession;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setProfession(Profession profession) {
        this.profession = profession;
    }
    @Override
    public String toString() {
        return "Character: "+name+" Level: "+level;
    }

    public void AddToProfession(){
        this.getProfession().getCharacters().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Character)) return false;
        Character character = (Character) o;
        return level == character.level && Objects.equals(name, character.name) && Objects.equals(profession, character.profession);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, level, profession);
    }
}