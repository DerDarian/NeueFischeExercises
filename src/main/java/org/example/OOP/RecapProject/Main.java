package org.example.OOP.RecapProject;

import java.math.BigDecimal;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService(new ProductRepo(), new OrderRepo());
        shopService.registerProduct("Banane", BigDecimal.valueOf(0.2), new Stock(1000));
        shopService.registerProduct("Avocado", BigDecimal.valueOf(1.49), new Stock(350));
        shopService.registerProduct("Mate-Eistee", BigDecimal.valueOf(0.89), new Stock(3));

        InteractiveProductManagementSystem.start(shopService);

    }
}
