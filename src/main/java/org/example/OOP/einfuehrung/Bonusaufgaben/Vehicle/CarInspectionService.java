package org.example.OOP.einfuehrung.Bonusaufgaben.Vehicle;

public class CarInspectionService {

    public boolean hasFourTires(Car car) {
        return car.getNumberOfTires() == 4;
    }

    public boolean hasSeatbeltTest(Car car) {
        return car.isSeatBelt();
    }

    public boolean hasAirbagTest(Car car) {
        return car.isAirbag();
    }

    public boolean hasSuffientDoors(Car car) {
        return car.getNumberOfDoors() == 3 ||  car.getNumberOfDoors() == 5;
    }

    public boolean checkCar(Car car) {
        return hasSuffientDoors(car) &&  hasSeatbeltTest(car) && hasFourTires(car) && hasAirbagTest(car);
    }
}
