package OOP.RecapProject;

import org.example.OOP.RecapProject.Order;
import org.example.OOP.RecapProject.OrderRepo;
import org.example.OOP.RecapProject.Product;
import org.example.OOP.RecapProject.Stock;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;

public class OrderRepoTest {

    @Test
    public void testValidatePublicId() {
        OrderRepo orderRepo = new OrderRepo();
        assert(orderRepo.validatePublicId("2024-11-05_99"));
        assert(!orderRepo.validatePublicId("2024-11-05-99"));
    }

    @Test
    public void testRegisterGetRemoveOrder() {
        OrderRepo orderRepo = new OrderRepo();

        Product banana = new Product("Banane", new Stock(1000), 0, BigDecimal.valueOf(0.2));
        Product avocado = new Product("Avocado", new Stock(300), 1, BigDecimal.valueOf(1.49));
        Product pear = new Product("Birne", new Stock(250), 1, BigDecimal.valueOf(0.9));


        HashMap<Product, Integer> products = new HashMap<>();
        products.put(banana, 100);
        products.put(avocado, 200);
        products.put(pear, 200);

        String key = orderRepo.registerOrder(products);
        orderRepo.registerOrder(new Date(), products);
        orderRepo.registerOrder(new Order(2, new Date(), products));

        assert(orderRepo.getAllOrders().size() == 3);
        assert (orderRepo.getOrder(key) != null);

        orderRepo.removeOrder(key);

        assert(orderRepo.getAllOrders().size() == 2);
        assert (orderRepo.getOrder(key) == null);

        assert(orderRepo.getOrdersByDate(new Date()).size() == 2);
        assert(orderRepo.getOrder(new Date(), 2) != null);

        orderRepo.removeOrder(new Date(), 2);
        assert(orderRepo.getOrder(new Date(), 2) == null);

    }

}
