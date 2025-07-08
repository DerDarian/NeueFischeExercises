package org.example.OOP.collections;

import java.util.List;

public record Zoo(List<Animal> animals) {
    public int amountFoodNeededInG(){
        int foodNeeded = 0;
        for (Animal animal : animals) {
            foodNeeded += animal.kind().gramFoodPerDayNeeded();
        }
        return foodNeeded;
    }
}
