package org.example.OOP.collections;

public class Medication {

    private String name;
    private double price;
    private boolean available;
    public Medication(String name, double price,  boolean available) {
        this.name = name;
        this.price = price;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "name: "  + name + ", price: " + price + ", available: " + available;
    }
}
