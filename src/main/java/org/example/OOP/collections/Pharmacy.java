package org.example.OOP.collections;

import java.util.HashMap;

public class Pharmacy {
    private final HashMap<String,Medication> stock = new HashMap<>();

    public int getCount(){return stock.size();}
    public void save(Medication medication){stock.put(medication.getName(),medication);}
    public Medication find(String name){try{return stock.get(name);}catch(Exception e){return null;}}
    public void delete(String name){stock.remove(name);}
    public void printStock(){
        StringBuilder builder = new StringBuilder();
        for (Medication medication : stock.values()){
            builder.append(medication.toString()).append("; ");
        }
        System.out.println(builder.toString());
    }
}
