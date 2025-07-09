package org.example.OOP.RecapProject;

import java.math.BigDecimal;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ShopService shopService = new ShopService(new ProductRepo(), new OrderRepo());
        shopService.registerProduct("Banane", BigDecimal.valueOf(0.2), new Stock(1000));
        shopService.registerProduct("Avocado", BigDecimal.valueOf(1.49), new Stock(350));
        shopService.registerProduct("Mate-Eistee", BigDecimal.valueOf(0.89), new Stock(3));

        HashMap<Product, Integer> products = new HashMap<>();
        products.put(shopService.getByProductNumber(0), 50);
        products.put(shopService.getByProductNumber(1), 17);
        products.put(shopService.getByProductNumber(2), 10);

        String key = shopService.registerOrder(products);
        System.out.println(key);

        HashMap<Product, Integer> products2 = new HashMap<>();
        products2.put(shopService.getByProductNumber(0), 50);
        products2.put(shopService.getByProductNumber(1), 17);
        products2.put(shopService.getByProductNumber(2), 3);

        String key2 = shopService.registerOrder(products2);
        System.out.println(key2);

    }
}
