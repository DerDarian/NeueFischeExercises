package org.example.OOP.einfuehrung.Bonusaufgaben.Vehicle;

import java.util.Scanner;

public class OOPEinfBonusVehicleMain {
    public static void main(String[] args) {
        Car car = new Car(4, 3, true, true, 0, "Auto", 0.8);
        car.accelerate(20);
        car.accelerate(15);
        car.accelerate();

        Bycicle b = new Bycicle(1, "Fahrrad", 0.5);
        try{
            b.accelerate(20);
            b.accelerate(25);
            b.accelerate(25);
            b.accelerate(2);}
        catch(Exception e){
            System.out.println(e.getMessage());
        }

        Vehicle v;

        System.out.println("a = Auto, f = Fahrrad, q = quit");
        Scanner sc = new Scanner(System.in);
        while(true){
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("q")){return;}
            if(input.equalsIgnoreCase("a")){ v = new Car(4, 3, true, true, 0, "Auto", 0.8); break;}
            if(input.equalsIgnoreCase("f")){ v = new Bycicle(0, "Fahrrad", 0.5); break;}
        }
        System.out.println("a = Beschleunigen, b = bremsen, q = quit");
        while(true){
            String input = sc.nextLine();
            if(input.equalsIgnoreCase("q")){return;}
            if(input.equalsIgnoreCase("a")){
                try{v.accelerate(10);}
                catch(Exception e){
                    System.out.println(e.getMessage());
                }}
            if(input.equalsIgnoreCase("b")){ v.brake();}
        }
    }
}
