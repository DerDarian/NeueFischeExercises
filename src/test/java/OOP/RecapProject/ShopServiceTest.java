package OOP.RecapProject;

import org.example.OOP.RecapProject.*;
import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class ShopServiceTest {
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    @Test
    public void testRegisterOrder(){
        ShopService shopService = new ShopService(new ProductRepo(), new OrderRepo());
        shopService.registerProduct("Banane", BigDecimal.valueOf(0.2), new Stock(1000));
        shopService.registerProduct("Avocado", BigDecimal.valueOf(1.49), new Stock(350));
        shopService.registerProduct("Mate-Eistee", BigDecimal.valueOf(0.89), new Stock(3));

        HashMap<Product, Integer> products = new HashMap<>();
        products.put(shopService.getByProductNumber(0), 50);
        products.put(shopService.getByProductNumber(1), 17);
        products.put(shopService.getByProductNumber(2), 10);

        String key = shopService.registerOrder(products);
        assert(key.equals("Invalid Order"));

        products.put(shopService.getByProductNumber(2), -10);
        key = shopService.registerOrder(products);
        assert(key.equals("Invalid Order"));

        products.put(shopService.getByProductNumber(2), 3);
        key = shopService.registerOrder(products);
        assert(key.equals(formatter.format(new Date()) + "_0"));
    }

    @Test
    public void testPlaceOrder(){
        ShopService shopService = new ShopService(new ProductRepo(), new OrderRepo());
        shopService.registerProduct("Banane", BigDecimal.valueOf(0.2), new Stock(1000));
        shopService.registerProduct("Avocado", BigDecimal.valueOf(1.49), new Stock(350));
        shopService.registerProduct("Mate-Eistee", BigDecimal.valueOf(0.89), new Stock(3));

        HashMap<Product, Integer> products = new HashMap<>();
        products.put(shopService.getByProductNumber(0), 50);
        products.put(shopService.getByProductNumber(1), 17);
        products.put(shopService.getByProductNumber(2), 3);

        assert(shopService.placeOrder(shopService.registerOrder(products)));
        assert(shopService.getByProductNumber(0).stock().getAmount() == 950);
        assert(shopService.getByProductNumber(1).stock().getAmount() == 333);
        assert(shopService.getByProductNumber(2).stock().getAmount() == 0);

    }
}
