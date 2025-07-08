package org.example.OOP.collections;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) throws ParseException {
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

        Owner o = new Owner("Marco", "m", "Polostraße 3, Markhausen");
        Owner o2 = new  Owner("Lily", "f", "Feenallee 5, Zauberstadt");
        Owner o3 = new Owner("Lara", "d", "Larifarigasse 17, Liebdorf");

        Species tiger_s = new  Species("Tiger", 5000);
        Species elephant_s = new  Species("Elephant", 150000);
        Species cat_s = new  Species("Katze", 4);

        Animal tiger = new Animal(0, "Tobi", dateFromString("2015-03-02") , tiger_s, o);
        Animal elephant = new Animal(0, "Erika", dateFromString("2000-01-17"), elephant_s, o2);
        Animal elephant2 = new Animal(0, "Erika", dateFromString("2000-01-17"), elephant_s, o2);
        Animal cat = new Animal(1, "Karina",  dateFromString("2019-06-06"), cat_s, o3);
        System.out.println(tiger);
        System.out.println(elephant);
        System.out.println(cat);
        System.out.println(elephant2.equals(elephant));
        System.out.println(tiger.equals(elephant));

        Zoo zoo = new Zoo(Arrays.asList(tiger,elephant,cat));
        System.out.println(zoo);
        System.out.println(zoo.amountFoodNeededInG());

    }

    private static Date dateFromString(String s) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        return df.parse(s);
    }
}
