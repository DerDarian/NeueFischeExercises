package org.example.OOP.einfuehrung.Bonusaufgaben.Vehicle;

import java.util.Objects;

public class Car extends Vehicle{
    int numberOfTires;
    int numberOfDoors;
    boolean seatBelt;
    boolean airbag;

    public Car(int numberOfTires, int numberOfDoors, boolean seatBelt, boolean airbag, int id, String name, double velocity) {
        this.numberOfTires = numberOfTires;
        this.numberOfDoors = numberOfDoors;
        this.seatBelt = seatBelt;
        this.airbag = airbag;
        this.id = id;
        this.name = name;
        this.velocity = velocity;
    }

    public int accelerate(int kmh) {
        this.speed += (int)(kmh * velocity);
        System.out.println(this.speed + "KmH");
        return this.speed;
    }

    public int accelerate() {
        this.speed += (int)(10 * velocity);
        System.out.println(this.speed + "KmH");
        return this.speed;
    }

    public boolean isAirbag() {
        return airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    public boolean isSeatBelt() {
        return seatBelt;
    }

    public void setSeatBelt(boolean seatBelt) {
        this.seatBelt = seatBelt;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public void setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    public int getNumberOfTires() {
        return numberOfTires;
    }

    public void setNumberOfTires(int numberOfTires) {
        this.numberOfTires = numberOfTires;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return numberOfTires == car.numberOfTires && numberOfDoors == car.numberOfDoors && seatBelt == car.seatBelt && airbag == car.airbag &&  id == car.id && name.equals(car.name) && velocity == car.velocity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfTires, numberOfDoors, seatBelt, airbag);
    }

    @Override
    public String toString() {
        return "Car{" +
                "numberOfTires=" + numberOfTires +
                ", numberOfDoors=" + numberOfDoors +
                ", seatBelt=" + seatBelt +
                ", airbag=" + airbag +
                ", id=" + id +
                ", name='" + name +
                ", velocity=" + velocity +
                '}';
    }
}
