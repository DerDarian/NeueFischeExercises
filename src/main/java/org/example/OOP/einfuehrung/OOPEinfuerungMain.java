package org.example.OOP.einfuehrung;

import javax.print.attribute.standard.Media;

public class OOPEinfuerungMain {

    public static void main(String[] args) {
        Car car = new Car("Schmaudi", "AAAHHH", "red", 2012, 4, 4, true, true);
        car.toggleMotor();

        Car car2 = new Car("Bockwagen", "B3U4Gamma0", "blue", 2017, 2, 4, true, true);
        car2.toggleMotor();
        System.out.println(car2);
        System.out.println(car2.accelerate() + "KmH");

        Person p1 = new Person("John", "Johnson", 30, "Male");
        Person p2 = new Person("Mary", "Maria", 38, "Female");
        p1.introduce();
        p2.introduce();

        StatischFinal.incrementTotalCount();
        StatischFinal sf = new StatischFinal();
        sf.incrementInstanceCount();
        System.out.println(sf);

        System.out.println(Calculator.add(1,2,3));
        System.out.println(Calculator.add(1.5,2.6,3.7));
        System.out.println(Calculator.sub(10,2,3));
        System.out.println(Calculator.sub(10.7,2.3,3.9));
        System.out.println(Calculator.mult(1,2,3));
        System.out.println(Calculator.mult(1.4,2.3,3.4));
        System.out.println(Calculator.div(10,2,3));
        System.out.println(Calculator.div(10.7,2.3,3.9));

        Playlable media = new MusicPlayer();
        Playlable media2 = new VideoPlayer();

        MediaController mediaController = new MediaController();
        mediaController.playMedia(media);
        mediaController.playMedia(media2);

    }
}
