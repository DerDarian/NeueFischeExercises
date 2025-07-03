package org.example.OOP.vererbung;

public class Car extends Vehicle{
    int numberOfDoor;
    int ps;
    boolean automatic;
    boolean electric;

    public Car(String manufacturer, String model, int yearOfManufacture,  int numberOfDoor, int ps,  boolean automatic, boolean electric) {
        super(manufacturer, model, yearOfManufacture);
        this.numberOfDoor = numberOfDoor;
        this.ps = ps;
        this.automatic = automatic;
        this.electric = electric;
    }

    @Override
    public void printVehicleInformation(){
        System.out.println("Car{ Manufacturer: " + manufacturer + " Model: " + model + " Year of Manufacture: " + yearOfManufacture + " Number of Doors: " + numberOfDoor + " PS: " + ps + " Automatic: " + automatic + " Electric: " + electric + " }");
    }
}
