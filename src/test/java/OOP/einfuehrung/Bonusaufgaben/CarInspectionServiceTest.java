package OOP.einfuehrung.Bonusaufgaben;

import org.example.OOP.einfuehrung.Bonusaufgaben.Vehicle.Car;
import org.example.OOP.einfuehrung.Bonusaufgaben.Vehicle.CarInspectionService;
import org.junit.Test;

public class CarInspectionServiceTest {
    @Test
    public void hasFourTiresTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car(4, 4, true, true, 1, "A", 1);
        Car car2 = new Car(2, 4, true, true, 1, "A", 1);

        assert(carInspectionService.hasFourTires(car));
        assert(!carInspectionService.hasFourTires(car2));
    }

    @Test
    public void hasSeatbeltTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car(4, 4, true, true, 1, "A", 1);
        Car car2 = new Car(2, 4, false, true, 1, "A", 1);

        assert(carInspectionService.hasSeatbeltTest(car));
        assert(!carInspectionService.hasSeatbeltTest(car2));
    }

    @Test
    public void hasAirbagTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car(4, 4, true, true, 1, "A", 1);
        Car car2 = new Car(2, 4, false, false, 1, "A", 1);

        assert(carInspectionService.hasAirbagTest(car));
        assert(!carInspectionService.hasAirbagTest(car2));
    }

    @Test
    public void hasSuffientDoorsTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car(3, 3, true, true, 1, "A", 1);
        Car car2 = new Car(5, 5, false, false, 1, "A", 1);
        Car car3 = new Car(2, 2, false, false, 1, "A", 1);
        Car car4 = new Car(4, 4, false, false, 1, "A", 1);
        Car car5 = new Car(6, 6, false, false, 1, "A", 1);

        assert(carInspectionService.hasSuffientDoors(car));
        assert(carInspectionService.hasSuffientDoors(car2));
        assert(!carInspectionService.hasSuffientDoors(car3));
        assert(!carInspectionService.hasSuffientDoors(car4));
        assert(!carInspectionService.hasSuffientDoors(car5));
    }

    @Test
    public void checkCarTest() {
        CarInspectionService carInspectionService = new CarInspectionService();
        Car car = new Car(3, 3, true, true, 1, "A", 1);
        Car car2 = new Car(4, 4, true, true, 1, "A", 1);
        Car car3 = new Car(4, 5, false, true, 1, "A", 1);
        Car car4 = new Car(4, 5, true, false, 1, "A", 1);
        Car car5 = new Car(4, 6, true, true, 1, "A", 1);

        Car car6 = new Car(4, 3, true, true, 1, "A", 1);
        Car car7 = new Car(4, 5, true, true, 1, "A", 1);

        assert(!carInspectionService.checkCar(car));
        assert(!carInspectionService.checkCar(car2));
        assert(!carInspectionService.checkCar(car3));
        assert(!carInspectionService.checkCar(car4));
        assert(!carInspectionService.checkCar(car5));

        assert(carInspectionService.checkCar(car6));
        assert(carInspectionService.checkCar(car7));
    }

}
