package org.example.OOP.BigDecimal;

import java.util.Objects;

public record Client(String name, String firstName, String customerId) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return client.customerId.equals(this.customerId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(this.customerId);
    }
}
