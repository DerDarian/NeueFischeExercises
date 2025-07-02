package org.example.OOP.einfuehrung.Bonusaufgaben.Animal;

public class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return name.equals(animal.name);
    }
}
