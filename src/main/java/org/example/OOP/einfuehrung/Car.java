package org.example.OOP.einfuehrung;

import java.util.Objects;

public class Car {
    String brand;
    String model;
    String color;
    int yearManufacture;
    boolean started = false;
    int speedKmH = 0;
    int numberOfTires;
    int numberOfDoors;
    boolean seatBelt;
    boolean airbag;

    public Car(String brand, String model, String color, int yearManufacture, int numberOfTires, int numberOfDoors, boolean seatBelt, boolean airbag) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearManufacture = yearManufacture;
        this.numberOfTires = numberOfTires;
        this.numberOfDoors = numberOfDoors;
        this.seatBelt = seatBelt;
        this.airbag = airbag;
    }


    public void toggleMotor(){
        this.started = !started;
        System.out.println("Motor is now " + (this.started?"ON":"OFF"));
    }

    public int accelerate(){
        if(started) {
            speedKmH += 10;
        }
        return speedKmH;
    }

    public int getSpeedKmH() {return this.speedKmH;}

    public String getBrand() {return this.brand;}
    public String getModel() {return this.model;}
    public String getColor() {return this.color;}
    public int getYearManufacture() {return this.yearManufacture;}

    public boolean isStarted() {return this.started;}

    public void setBrand(String brand) {
        this.brand = brand;
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
        return yearManufacture == car.yearManufacture && started == car.started && speedKmH == car.speedKmH && numberOfTires == car.numberOfTires && numberOfDoors == car.numberOfDoors && seatBelt == car.seatBelt && airbag == car.airbag && Objects.equals(brand, car.brand) && Objects.equals(model, car.model) && Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, yearManufacture, started, speedKmH, numberOfTires, numberOfDoors, seatBelt, airbag);
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", yearManufacture=" + yearManufacture +
                ", started=" + started +
                ", speedKmH=" + speedKmH +
                ", numberOfTires=" + numberOfTires +
                ", numberOfDoors=" + numberOfDoors +
                ", seatBelt=" + seatBelt +
                ", airbag=" + airbag +
                '}';
    }
}
