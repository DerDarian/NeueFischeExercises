package org.example.OOP.RecapProject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public record Order(int id, Date date, HashMap<Product, Integer> products) {
    public BigDecimal getSum(){
        BigDecimal sum = BigDecimal.ZERO;
        for (Product product : products.keySet()) {
            sum = sum.add(product.price().multiply(new BigDecimal(products.get(product))));
        }
        return sum;
    }

    public void changeProductAmount(Product product, Integer amount){
        if(amount < 0){
            throw new IllegalArgumentException("Amount must be greater than or equal to zero");
        }
        if(amount == 0)
            products.remove(product);
        else
            products.put(product, amount);
    }
}
