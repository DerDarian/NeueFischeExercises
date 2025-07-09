package OOP.RecapProject;

import org.example.OOP.RecapProject.Product;
import org.example.OOP.RecapProject.ProductRepo;
import org.example.OOP.RecapProject.Stock;
import org.junit.Test;

import java.math.BigDecimal;

public class ProductRepoTest {

    @Test
    public void testRegisterRemoveProduct(){
        ProductRepo productRepo = new ProductRepo();
        productRepo.registerProduct("Apfel", BigDecimal.valueOf(0.9));
        productRepo.registerProduct("Karotte", BigDecimal.valueOf(0.05), new Stock(500));
        productRepo.registerProduct(new Product("Karotte", new Stock(500), 5, BigDecimal.valueOf(0.05)));
        productRepo.registerProduct("Birne", BigDecimal.valueOf(0.9));

        assert(productRepo.getProducts().size() == 4);
        assert(productRepo.productExists(1));
        assert(productRepo.getProduct(6).name().equals("Birne"));

        productRepo.removeProduct(6);
        productRepo.removeProduct(0);

        assert(!productRepo.productExists(0));
        assert(!productRepo.productExists(6));
        assert(productRepo.getProducts().size() == 2);

    }

    @Test
    public void testReduceStockBy(){
        ProductRepo productRepo = new ProductRepo();

        productRepo.registerProduct("Karotte", BigDecimal.valueOf(0.05), new Stock(500));
        productRepo.reduceStockBy(0,307);

        try{
            productRepo.reduceStockBy(0,307);
        }catch (Exception e){
            assert(e.getMessage().equals("reduction exceeds stock amount"));
        }

        try{
            productRepo.reduceStockBy(0,-307);
        }catch (Exception e){
            assert(e.getMessage().equals("reduction cannot be less than 0"));
        }

        assert(productRepo.getProduct(0).stock().getAmount() == 193);

    }

}
