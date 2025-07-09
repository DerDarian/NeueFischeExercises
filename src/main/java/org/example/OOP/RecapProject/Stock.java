package org.example.OOP.RecapProject;

public class Stock {
    private int amount = 0;

    public Stock(int amount) {
        if(amount < 0){
            throw new IllegalArgumentException("Amount cannot be negative");
        }
        this.amount = amount;
    }

    public Stock() {}

    public int getAmount() {
        return amount;
    }

    public void reduceStockBy(int reduction) {
        if(reduction > amount)
            throw new IllegalArgumentException("reduction exceeds stock amount");
        if(reduction < 0)
            throw new IllegalArgumentException("reduction cannot be less than 0");
        this.amount -= reduction;
    }

    public void increaseStockBy(int amount) {
        this.amount += amount;
    }

    @Override
    public String toString() {
        return "amount: " + amount;
    }
}
