package org.example.OOP.collections;

public class Kurs {

    String name;
    String dozent;
    String raum;

    public Kurs(String name, String dozent, String raum) {
        this.name = name;
        this.dozent = dozent;
        this.raum = raum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDozent() {
        return dozent;
    }

    public void setDozent(String dozent) {
        this.dozent = dozent;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }
}
