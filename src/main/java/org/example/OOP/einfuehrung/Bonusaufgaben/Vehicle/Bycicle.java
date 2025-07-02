package org.example.OOP.einfuehrung.Bonusaufgaben.Vehicle;

public class Bycicle extends Vehicle {

    public Bycicle(int id, String name, double velocity) {
        this.id = id;
        this.name = name;
        this.velocity = velocity;
    }

    public int accelerate(int kmh) {
        int acceleration = (int)(kmh * velocity);
        if(speed + acceleration < 35) {
            this.speed += acceleration;
            System.out.println(this.speed + "KmH");
        }else{
            throw new IllegalArgumentException("Speed cannot be above 34 KmH");
        }
        return this.speed;
    }
}
