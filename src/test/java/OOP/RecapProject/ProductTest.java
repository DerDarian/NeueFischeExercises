package OOP.RecapProject;

import org.example.OOP.RecapProject.Product;
import org.example.OOP.RecapProject.Stock;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductTest {

    @Test
    public void testHashCode(){
        Product p = new Product("Banane", new Stock(), 0, BigDecimal.valueOf(0.2));
        Product p2 = new Product("Avocado", new Stock(), 1, BigDecimal.valueOf(1.49));
        assert(p.hashCode() == 0);
        assert(p2.hashCode() == 1);
    }

    @Test
    public void testConstructor(){
        try {
            new Product("Banane", new Stock(), 0, BigDecimal.valueOf(-0.2));
        }catch (Exception e){
            assert(e.getMessage().equals("Price must be greater than zero"));
        }

        try {
            new Product("Banane", new Stock(), 0, BigDecimal.valueOf(0));
        }catch (Exception e){
            assert(e.getMessage().equals("Price must be greater than zero"));
        }

        try {
            new Product("Banane", new Stock(), -1, BigDecimal.valueOf(0.2));
        }catch (Exception e){
            assert(e.getMessage().equals("Product number must be greater than or equal to zero"));
        }
    }
}
