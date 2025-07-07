package org.example.OOP.collections;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String lastName;
    private int id;
    private List<Kurs> kurse = new ArrayList<>();


    public Student() {
    }
    public Student(String name, String lastName, int id) {
        this.name = name;
        this.lastName = lastName;
        this.id = id;
    }
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}
    public List<Kurs> getKurse() {return kurse;}
    public void addKurs(Kurs kurs) {kurse.add(kurs);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public String toString() {
        return name + " " + lastName + ", ID: " + id;
    }
}
