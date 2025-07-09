package org.example.OOP.RecapProject;

import java.math.BigDecimal;
import java.util.Scanner;

public class InteractiveProductManagementSystem {

    // product {name} {initial stock} {price}
    // {id} name:{name} stock:{amount} price:{price}
    final static String INSTRUCTIONS = "inventory - prints the inventory\n"
                                + "orders - prints open orders\n"
                                + "register - registers a new product\n"
                                + "edit product - edits product\n"
                                + "q - quit\n";

    public static void start(ShopService shopService){
        System.out.println("Instructions:");
        System.out.println(INSTRUCTIONS);

        Scanner scanner = new Scanner(System.in);
        while(true) {
            String input = scanner.nextLine();
            if(input.equals("q")){
                break;
            }
            actOnDecision(decide(input), shopService);
        }


    }

    private static void actOnDecision(String input, ShopService shopService){
        System.out.println(input);
        switch (input){
            case "inventory - prints the inventory":
                System.out.println("Inventory:");
                System.out.println(shopService.productRepo.getProducts());
                break;
            case "orders - prints open orders":
                System.out.println("Open orders:");
                System.out.println(shopService.orderRepo.getAllOrders());
                break;
            case "register - registers a new product":
                registerDialogue(shopService);
                break;
            case "edit product - edits product":
                editDialogue(shopService);
                break;
        }
    }

    private static void registerDialogue(ShopService shopService){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Name:");
        String name = scanner.nextLine();
        System.out.println("Price:");
        String price = scanner.nextLine();
        System.out.println("Quantity:");
        int quantity = scanner.nextInt();
        shopService.registerProduct(name, BigDecimal.valueOf(Double.parseDouble(price)), new Stock(quantity));
        System.out.println("Registration successful! : " + shopService.productRepo.getProducts().getLast());
    }
    private static void editDialogue(ShopService shopService){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Product Id:");
        int productId = scanner.nextInt();
        Product product = shopService.getByProductNumber(productId);
        System.out.println("Editing: " + product);
        System.out.println();
        System.out.println("Leave empty to keep old value");
        System.out.println("Old name: " + product.name() + "; New name:");
        String name = scanner.nextLine();
        System.out.println("Old price: " + product.price() + "; new price:");
        String price = scanner.nextLine();
        System.out.println("Old quantity: " + product.stock().getAmount() + "; New quantity:");
        String quantity = scanner.nextLine();

        String name_param = product.name();
        if(!name.isBlank())
            name_param = name;

        BigDecimal price_param = product.price();
        if(!price.isBlank())
            price_param = BigDecimal.valueOf(Double.parseDouble(price));

        int quantity_param = product.stock().getAmount();
        if(!quantity.isBlank())
            quantity_param = Integer.parseInt(quantity);

        shopService.productRepo.registerProduct(new Product(name_param, new Stock(quantity_param), productId, price_param));
        System.out.println("Registration successful! : " + shopService.getByProductNumber(productId));
    }


    private static String decide(String input){
        String[] possibilities = INSTRUCTIONS.split("\n");
        String decision = "";
        for(String possibility : possibilities){
            if(possibility.startsWith(input)){
                if(!decision.isBlank()){
                    return "cannot decide";
                }
                decision = possibility;
            }
        }

        return decision;
    }
}
