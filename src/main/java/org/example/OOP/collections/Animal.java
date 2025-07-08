package org.example.OOP.collections;

import java.util.Date;

public record Animal(int id, String name, Date birthday, Species kind, Owner owner) {
}
