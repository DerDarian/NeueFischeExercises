package org.example.OOP.RecapProject;

import java.math.BigDecimal;

public record Product(String name, Stock stock, int productNumber, BigDecimal price) {

    public Product(String name, Stock stock, int productNumber, BigDecimal price) {
        if(price.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        if(productNumber < 0){
            throw new IllegalArgumentException("Product number must be greater than or equal to zero");
        }
        this.name = name;
        this.stock = stock;
        this.productNumber = productNumber;
        this.price = price;
    }

    @Override
    public int hashCode(){
        return this.productNumber;
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof Product p))
            return false;
        return this.productNumber == p.productNumber;
    }
}
