package OOP.RecapProject;

import org.example.OOP.RecapProject.Order;
import org.example.OOP.RecapProject.Product;
import org.example.OOP.RecapProject.Stock;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class OrderTest {
    @Test
    public void testSum(){
        HashMap<Product, Integer> products = new HashMap<>();
        products.put(new Product("Banane", new Stock(1000), 0, BigDecimal.valueOf(0.2)), 5);
        products.put(new Product("Avocado", new Stock(1000), 1, BigDecimal.valueOf(1.49)), 1);
        products.put(new Product("Mate-Eistee", new Stock(1000), 2, BigDecimal.valueOf(0.89)), 3);

        Order o = new Order(0, new Date(), products);

        assert(o.getSum().equals(BigDecimal.valueOf(5.16)));
    }

    @Test
    public void testChangeProductAmount(){
        HashMap<Product, Integer> products = new HashMap<>();
        Product product = new Product("Banane", new Stock(1000), 0, BigDecimal.valueOf(0.2));
        products.put(product, 5);

        Order o = new Order(0, new Date(), products);
        o.changeProductAmount(product, 3);

        assert(o.products().get(product) == 3);

        try{
            o.changeProductAmount(product, -3);
        }catch (Exception e){
            assert(e.getMessage().equals("Amount must be greater than or equal to zero"));
        }

        o.changeProductAmount(product, 0);
        assert(o.products().isEmpty());
    }
}
