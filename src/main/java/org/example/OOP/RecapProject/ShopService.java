package org.example.OOP.RecapProject;

import java.math.BigDecimal;
import java.util.HashMap;

public class ShopService {
    ProductRepo productRepo;
    OrderRepoInterface orderRepo;

    public ShopService(ProductRepo productRepo, OrderRepoInterface orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getByProductNumber(int productNumber) {
        return productRepo.getProduct(productNumber);
    }

    public String registerOrder(HashMap<Product, Integer> products) {
        if(validateOrder(products))
            return orderRepo.registerOrder(products);
        return "Invalid Order";
    }

    public boolean placeOrder(String key){
        try {
            orderRepo.getOrder(key).products().forEach((product, amount) -> {
                product.stock().reduceStockBy(amount);
            });
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void registerProduct(String name, BigDecimal price, Stock stock) {
        productRepo.registerProduct(name, price, stock);
    }

    private boolean validateOrder(HashMap<Product, Integer> products) {
        for(Product product : products.keySet()){
            if(!productRepo.productExists(product.productNumber())){
                System.out.println("Product not found: " + product);
                return false;
            }
            if(product.stock().getAmount() < products.get(product)){
                System.out.println("Order exceeds stock. " + products.get(product) + " of " + product + " ordered");
                return false;
            }
            if(0 >= products.get(product)){
                System.out.println("Cannot order 0 or less. " + products.get(product) + " of " + product + " ordered");
                return false;
            }

        }
        return true;
    }

}
