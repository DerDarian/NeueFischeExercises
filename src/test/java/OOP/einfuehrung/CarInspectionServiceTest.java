package OOP.einfuehrung;

import org.example.OOP.einfuehrung.Car;
import org.example.OOP.einfuehrung.CarInspectionService;
import org.junit.Test;

public class CarInspectionServiceTest {
    @Test
    public void hasFourTiresTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 4, true, true);
        Car car2 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 2, 4, true, true);

        assert(carInspectionService.hasFourTires(car));
        assert(!carInspectionService.hasFourTires(car2));
    }

    @Test
    public void hasSeatbeltTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 4, true, true);
        Car car2 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 2, 4, false, true);

        assert(carInspectionService.hasSeatbeltTest(car));
        assert(!carInspectionService.hasSeatbeltTest(car2));
    }

    @Test
    public void hasAirbagTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 4, true, true);
        Car car2 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 2, 4, false, false);

        assert(carInspectionService.hasAirbagTest(car));
        assert(!carInspectionService.hasAirbagTest(car2));
    }

    @Test
    public void hasSuffientDoorsTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car("Schmaudi", "AAAHHH", "red", 2012, 3, 3, true, true);
        Car car2 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 5, 5, false, false);
        Car car3 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 2, 2, false, false);
        Car car4 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 4, 4, false, false);
        Car car5 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 6, 6, false, false);

        assert(carInspectionService.hasSuffientDoors(car));
        assert(carInspectionService.hasSuffientDoors(car2));
        assert(!carInspectionService.hasSuffientDoors(car3));
        assert(!carInspectionService.hasSuffientDoors(car4));
        assert(!carInspectionService.hasSuffientDoors(car5));
    }

    @Test
    public void checkCarTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car("Schmaudi", "AAAHHH", "red", 2012, 3, 3, true, true);
        Car car2 = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 4, true, true);
        Car car3 = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 5, false, true);
        Car car4 = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 5, true, false);
        Car car5 = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 6, true, true);

        Car car6 = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 3, true, true);
        Car car7 = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 5, true, true);

        assert(!carInspectionService.checkCar(car));
        assert(!carInspectionService.checkCar(car2));
        assert(!carInspectionService.checkCar(car3));
        assert(!carInspectionService.checkCar(car4));
        assert(!carInspectionService.checkCar(car5));

        assert(carInspectionService.checkCar(car6));
        assert(carInspectionService.checkCar(car7));
    }

}
