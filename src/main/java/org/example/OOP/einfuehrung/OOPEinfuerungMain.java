package org.example.OOP.einfuehrung;

public class OOPEinfuerungMain {

    public static void main(String[] args) {
        Car car = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 4, true, true);
        car.toggleMotor();

        Car car2 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 2, 4, true, true);
        car2.toggleMotor();
        System.out.println(car2);
        System.out.println(car2.accelerate() + "KmH");

        Person p1 = new Person("John", "Johnson", 30, "Male");
        Person p2 = new Person("Mary", "Maria", 38, "Female");
        p1.introduce();
        p2.introduce();
    }
}
