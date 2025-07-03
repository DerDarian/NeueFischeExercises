package org.example.OOP.vererbung;

public class Motorcycle extends Vehicle {

    boolean isObnoxiouslyLoud;
    String type;

    public Motorcycle(String manufacturer, String model, int yearOfManufacture, boolean isObnoxiouslyLoud, String type) {
        super(manufacturer, model, yearOfManufacture);
        this.isObnoxiouslyLoud = isObnoxiouslyLoud;
    }

    @Override
    public void printVehicleInformation() {
        System.out.println("Motorcycle{ Manufacturer: " + manufacturer + " Model: " + model + " Year of Manufacture: " + yearOfManufacture + " Type: " + type +" isObnoxiouslyLoud: " + isObnoxiouslyLoud + " }");
    }
}
