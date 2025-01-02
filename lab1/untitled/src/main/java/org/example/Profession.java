package org.example;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Profession implements Serializable {
    @Id
    private String name;
    private int baseArmor;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Character> characters = new ArrayList<>();
    public Profession(String name, int baseArmor) {
        this.name = name;
        this.baseArmor = baseArmor;
    }

    public Profession() {

    }
    public String getName() {
        return name;
    }
    public int getBaseArmor() {
        return baseArmor;
    }
    public List<Character> getCharacters() {
        return characters;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setBaseArmor(int baseArmor) {
        this.baseArmor = baseArmor;
    }
    public void setCharacters(List<Character> characters) {
        this.characters = characters;
    }

}