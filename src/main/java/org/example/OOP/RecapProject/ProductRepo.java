package org.example.OOP.RecapProject;

import java.math.BigDecimal;
import java.util.*;

public class ProductRepo {
    private final Map<Integer, Product> products = new HashMap<>();

    private int generateProductNumber() {
        List<Integer> list = new ArrayList<>(products.keySet().stream().toList());
        if(list.isEmpty())
            return 0;

        Collections.sort(list);
        return list.getLast() + 1;
    }

    public Product getProduct(int productNumber) {
        return products.get(productNumber);
    }

    public boolean productExists(int productNumber) {
        return products.containsKey(productNumber);
    }

    public void registerProduct(String name, BigDecimal price) {
        registerProduct(new Product(name, new Stock(), generateProductNumber(), price));
    }

    public void registerProduct(String name, BigDecimal price, Stock stock) {
        registerProduct(new Product(name, stock, generateProductNumber(), price));
    }

    public void registerProduct(Product p) {
        products.put(p.productNumber(), p);
    }

    public void removeProduct(int productNumber) {
        products.remove(productNumber);
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public void reduceStockBy(int productNumber, int reduction) {
        try {
            products.get(productNumber).stock().reduceStockBy(reduction);
        }catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
