package org.example.OOP.BigDecimal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Account {
    final private String accountNumber;
    private BigDecimal balance =  BigDecimal.ZERO;
    final private List<Client> clients = new ArrayList<>();

    Account(String accountNumber, BigDecimal balance, Client ... clients) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.clients.addAll(Arrays.asList(clients));
    }

    Account(String accountNumber, Client ... clients) {
        this.accountNumber = accountNumber;
        this.clients.addAll(Arrays.asList(clients));
    }

    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        balance = balance.subtract(amount);
    }

    public BigDecimal getBalance() {return balance;}
    public List<Client> getClients() {return clients;}
    public String getAccountNumber() {return accountNumber;}

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Balance: " + balance + ", Clients: " + clients;
    }
}
