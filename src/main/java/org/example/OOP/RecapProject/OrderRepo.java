package org.example.OOP.RecapProject;

import java.text.SimpleDateFormat;
import java.util.*;

public class OrderRepo implements OrderRepoInterface{
    public final Map<String, Map<Integer, Order>> orders = new HashMap<>();
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Order getOrder(String publicId) {
        if(!validatePublicId(publicId)){
            return null;
        }
        String[] parts = publicId.split("_");
        return orders.get(parts[0]).get(Integer.parseInt(parts[1]));
    }

    @Override
    public String registerOrder(HashMap<Product, Integer> products) {
        return registerOrder(new Order(generateOrderId(), new Date(), products));
    }

    @Override
    public String registerOrder(Date d, HashMap<Product, Integer> products) {
        return registerOrder(new Order(generateOrderId(), d, products));
    }

    @Override
    public void removeOrder(String orderId) {
        if(!validatePublicId(orderId)){
            return;
        }
        String[] parts = orderId.split("_");
        orders.get(parts[0]).remove(Integer.parseInt(parts[1]));
    }

    @Override
    public String registerOrder(Order order) {
        orders.get(formatter.format(order.date())).put(order.id(), order);
        return makePublicId(order);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> returnValue = new ArrayList<>();
        orders.forEach((key, value) -> returnValue.addAll(value.values()));
        return returnValue;
    }

    public String makePublicId(Order order){
        return formatter.format(order.date()) + "_" + order.id();
    }

    public void removeOrder(Date d, int orderId) {
        orders.get(formatter.format(d)).remove(orderId);
    }

    public List<Order> getOrdersByDate(Date d) {
        return new ArrayList<>(orders.get(formatter.format(d)).values());
    }

    public Order getOrder(Date d, int orderId) {
        return orders.get(formatter.format(d)).get(orderId);
    }

    public boolean validatePublicId(String publicId){
        return publicId.matches("\\d{4}-\\d{2}-\\d{2}_\\d+");
    }

    private Integer generateOrderId() {
        Date date = new Date();
        String key = formatter.format(date);
        if(!orders.containsKey(key)) {
            orders.put(key, new HashMap<>());
        }
        List<Integer> list = new ArrayList<>(orders.get(key).keySet().stream().toList());
        if(list.isEmpty())
            return 0;
        Collections.sort(list);
        return list.getLast() + 1;
    }
}
