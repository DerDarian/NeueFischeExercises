package org.example.basics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.Arrays;

public class BasicsMain {

    public static int sum(Integer ... numbers){
        int sum = 0;
        for(int number :  numbers){
            sum += number;
        }

        return sum;
    }

    public static int findMax(Integer ... numbers) {
        if (numbers == null || numbers.length == 0) {
            throw new InvalidParameterException("Array is empty");
        }

        int max = numbers[0];
        for (int number : numbers) {
            if (number > max) {
                max = number;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {

        System.out.println("Gib eine Zahl ein.");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        if(!input.matches("^[0-9]+$")){
            throw new InvalidParameterException("Eingabe darf nur Zahlen enthalten.");
        }

        int i = Integer.parseInt(input);

        Integer[]  numbers = new Integer[i];
        for(int j=0;j<i;j++){
            numbers[j] = (Integer) (j + 1);
        }

        System.out.println(Arrays.toString(numbers));

        System.out.println();
        System.out.println("Summe: " + sum(numbers));
        System.out.println("Maximum: " + findMax(numbers));

        Integer[]  numbers2 = new Integer[i];
        for(int j=0; j<i; j++){
            numbers2[j] = (Integer) (j + i + 1);
        }

        Integer[] numbers3 = new Integer[i];
        for(int j=0; j<i; j++){
            numbers3[j] = (Integer) (numbers2[j] + numbers[j]);
        }

        System.out.println(Arrays.toString(numbers3));

    }
}
