package org.example.OOP.collections;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Schule schule = new Schule();

        schule.addStudent(new Student("Peter", "Peterson", 0));
        schule.addStudent(new Student("John", "Johnson", 1));
        schule.addStudent(new Student("Georg", "Georgson", 2));

        schule.print();

        schule.removeStudent(new Student("Peter", "Peterson", 0));
        System.out.println();
        schule.print();
        System.out.println();
        System.out.println(schule.findStudent(2));

        Sack<String> sack = new Sack<>(String.class);
        sack.add("A");
        sack.add("B");
        sack.add("C");
        sack.add("D");
        sack.add("E");
        sack.add("F");
        sack.add("G");
        sack.add("H");
        sack.add("I");
        sack.add("J");
        sack.add("K");
        sack.add("L");

        sack.print();
        System.out.println(sack.size());

        sack.removeLast();
        sack.print();

        sack.remove(2);
        sack.print();

        System.out.println(sack.get(1));

        System.out.println();

        Beutel<String> beutel = new Beutel<String>("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L");
        System.out.println(beutel);
        System.out.println(beutel.size());
        beutel.add("A");
        beutel.add("B");
        System.out.println(beutel);
        System.out.println(beutel.size());
        beutel.removeLast();
        System.out.println(beutel);
        System.out.println(beutel.size());
        beutel.remove(7);
        System.out.println(beutel);
        System.out.println(beutel.size());

        System.out.println(beutel.get(7));

    }
}
