package OOP.BigDecimal;

import org.example.OOP.BigDecimal.Account;
import org.example.OOP.BigDecimal.BankService;
import org.example.OOP.BigDecimal.Client;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

public class BankTests {

    @Test
    public void test(){
        exec(BigDecimal.valueOf(17.5));
        exec(BigDecimal.valueOf(30));
        exec(BigDecimal.valueOf(-925.03));
        exec(BigDecimal.ZERO);
    }

    private void exec(BigDecimal param) {
        Client a = new Client("A", "Ason", "0");
        Client b = new Client("B", "Bson", "1");
        Client c = new Client("C", "Cson", "2");

        BankService bankService = new BankService();

        String accountNumber = bankService.createAccount(param, a, b, c);

        List<String> list = bankService.splitAccount(accountNumber);
        BigDecimal sum = BigDecimal.ZERO;
        for(String s: list)
        {
            sum = sum.add(bankService.getAccount(s).getBalance());
        }
        list.forEach(bankService::printAccount);
        assert(sum.compareTo(param) == 0);
    }
}
