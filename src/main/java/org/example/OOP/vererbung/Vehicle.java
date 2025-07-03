package org.example.OOP.vererbung;

public class Vehicle {
    String manufacturer;
    String model;
    int yearOfManufacture;

    public Vehicle(String manufacturer, String model, int yearOfManufacture){
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void printVehicleInformation(){
        System.out.println("Vehicle{ Manufacturer: " + manufacturer + " Model: " + model + " Year of Manufacture: " + yearOfManufacture + " }");
    }
}
