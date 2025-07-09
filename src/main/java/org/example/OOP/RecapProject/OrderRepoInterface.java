package org.example.OOP.RecapProject;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface OrderRepoInterface {
    public String registerOrder(Order order);
    public String registerOrder(HashMap<Product, Integer> products);
    public String registerOrder(Date d, HashMap<Product, Integer> products);
    public void removeOrder(String orderId);
    public Order getOrder(String orderId);
    public List<Order> getAllOrders();
}
