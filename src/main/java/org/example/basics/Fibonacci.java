package org.example.basics;

public class Fibonacci {

    public static int getFibonacci(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;

        return getFibonacci(n - 1) + getFibonacci(n - 2);
    };

    public static double getFibonacciCustomStart(int n, double start) {

        if(n <= 0) return start;
        if(n == 1) return start + start;

        return getFibonacciCustomStart(n - 1, start) + getFibonacciCustomStart(n - 2, start);
    };
}
