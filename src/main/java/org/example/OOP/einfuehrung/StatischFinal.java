package org.example.OOP.einfuehrung;

public class StatischFinal {
    private static int totalCount = 0;
    private int instanceCount = 0;

    public static void incrementTotalCount(){++totalCount;}

    public void incrementInstanceCount(){++instanceCount;}

    @Override
    public String toString() {
        return "totalCount=" + totalCount + ", instanceCount=" + instanceCount;
    }
}
