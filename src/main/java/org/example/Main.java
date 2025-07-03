package org.example;

import org.example.OOP.vererbung.Car;
import org.example.OOP.vererbung.Motorcycle;
import org.example.OOP.vererbung.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.Arrays;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) throws IOException {

        Vehicle vehicle = new Vehicle("Raudi", "Schmodel", 2022);
        Car car = new Car("Fort", "Weit weg", 1999, 5, 42, false, false);
        Motorcycle motorcycle = new Motorcycle("Hinda", "Dort", 2017, false, "Sportbike");
        vehicle.printVehicleInformation();
        car.printVehicleInformation();
        motorcycle.printVehicleInformation();

    }
}