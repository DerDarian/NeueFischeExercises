package OOP.collections;

import org.example.OOP.collections.Medication;
import org.example.OOP.collections.Pharmacy;
import org.junit.Test;

public class PharmacyTest {

    @Test
    public void test() {
        Pharmacy pharmacy = new Pharmacy();
        pharmacy.save(new Medication("A", 3, true));
        pharmacy.save(new Medication("B", 4, true));
        pharmacy.save(new Medication("C", 5, true));
        pharmacy.save(new Medication("D", 6, true));

        assert(pharmacy.getCount() == 4);
        assert(pharmacy.find("B").getPrice() == 4);
        assert(pharmacy.find("E") == null);

        pharmacy.delete("B");
        assert(pharmacy.getCount() == 3);
        assert(pharmacy.find("B") == null);
        pharmacy.printStock();
    }
}
