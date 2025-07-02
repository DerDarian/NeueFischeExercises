package org.example.OOP.einfuehrung.Bonusaufgaben.Vehicle;

public abstract class Vehicle implements Acceleratable {
    int id;
    String name;
    double velocity;
    int speed = 0;

    public void brake(){this.speed = 0; System.out.println("0KmH");}
}
