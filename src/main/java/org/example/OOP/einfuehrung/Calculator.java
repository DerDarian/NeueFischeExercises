package org.example.OOP.einfuehrung;

public class Calculator {
    public static double add(double ... numbers) {
        double result = 0;
        for (double d : numbers) {
            result += d;
        }
        return result;
    }

    public static int add(int ... numbers) {
        int result = 0;
        for (int i : numbers) {
            result += i;
        }
        return result;
    }

    public static double sub(double ... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static int sub(int ... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result -= numbers[i];
        }
        return result;
    }

    public static double mult(double ... numbers) {
        double result = 1;
        for (double i : numbers) {
            result *= i;
        }
        return result;
    }

    public static int mult(int ... numbers) {
        int result = 1;
        for (int i : numbers) {
            result *= i;
        }
        return result;
    }

    public static double div(double ... numbers) {
        double result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result /= numbers[i];
        }
        return result;
    }

    public static int div(int ... numbers) {
        int result = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            result /= numbers[i];
        }
        return result;
    }

}
