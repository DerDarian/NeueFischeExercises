package org.example.OOP.BigDecimal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.security.SecureRandom;
import java.util.*;

public class BankService {
    final private Map<Client, List<Account>> accounts = new HashMap<>();
    final private Map<String, List<Client>> accountNumberOwnerMapping = new HashMap<>();


    public String createAccount(Client ... clients) {
        return createAccount(BigDecimal.ZERO, clients);
    }

    public String createAccount(BigDecimal amount, Client ... clients) {
        String accountNumber = "";
        do{
            accountNumber = generateAccountNumber();
        }while(accountNumberOwnerMapping.containsKey(accountNumber));
        Account a = new Account(accountNumber, amount, clients);
        for(Client c : clients){
            if(!accounts.containsKey(c)){
                accounts.put(c, new ArrayList<>());
            }
            accounts.get(c).add(a);
        }
        accountNumberOwnerMapping.put(a.getAccountNumber(), Arrays.asList(clients));
        return a.getAccountNumber();
    }

    private String generateAccountNumber() {

        String nmb = "0123456789";
        String uc = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String range = nmb + uc;

        Random random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            sb.append(range.charAt(random.nextInt(15)));
        }

        return sb.toString();
    }

    private void transferMoney(String from, String to, BigDecimal amount) {
        List<Client> clientsFrom = accountNumberOwnerMapping.get(from);
        List<Client> clientsTo = accountNumberOwnerMapping.get(to);

        for (Account a : accounts.get(clientsFrom.getFirst())) {
            if(a.getAccountNumber().equals(from)){
                for(Account b : accounts.get(clientsTo.getFirst())){
                    if(b.getAccountNumber().equals(to)){
                        b.deposit(amount);
                        a.withdraw(amount);
                        return;
                    }
                }
            }
        }
    }

    public List<String> splitAccount(String accountNumber){
        List<Client> clients = accountNumberOwnerMapping.get(accountNumber);
        Account oldAccount = null;
        for (Account a : accounts.get(clients.getFirst())) {
            if(a.getAccountNumber().equals(accountNumber)){
                oldAccount = a;
            }
        }

        if(oldAccount == null)
            throw new IllegalArgumentException("Account number not found");

        BigDecimal amountSum = BigDecimal.ZERO;
        List<BigDecimal> amounts = new ArrayList<>();
        for(Client c : clients){
            BigDecimal a = oldAccount.getBalance().divide(BigDecimal.valueOf(clients.size()), 2, RoundingMode.HALF_UP);
            amounts.add(a);
            amountSum = amountSum.add(a);
        }

        BigDecimal difference  = oldAccount.getBalance().subtract(amountSum);
        amounts.set(0, amounts.getFirst().add(difference));

        List<String> ids = new ArrayList<>();

        for(int i = 0; i < clients.size(); ++i){
            ids.add(createAccount(amounts.get(i), clients.get(i)));
            accounts.get(clients.get(i)).remove(oldAccount);
        }

        accountNumberOwnerMapping.remove(accountNumber);

        return ids;
    }

    public void printAccount(String accountNumber){
        List<Client> clients = accountNumberOwnerMapping.get(accountNumber);
        for(Account a : accounts.get(clients.getFirst())){
            if(a.getAccountNumber().equals(accountNumber)){
                System.out.println(a);
            }
        }
    }

    public Account getAccount(String accountNumber){
        List<Client> clients = accountNumberOwnerMapping.get(accountNumber);
        for(Account a : accounts.get(clients.getFirst())){
            if(a.getAccountNumber().equals(accountNumber)){
                return a;
            }
        }
        return null;
    }

}
