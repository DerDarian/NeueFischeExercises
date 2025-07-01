package org.example.basics;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Random;

public class Bonusaufgaben {
    public static void printLoop(String message, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(message);
        }
    }

    public static void printAll(String ... strings) {
        for (String s : strings) {
            if(s != null)
                System.out.print(s + " ");
        }
    }

    // --- NOVICE --- //

    public static boolean isOverZero(int number) {
        return number > 0;
    }

    public static boolean isOverZero(double number) {
        return number > 0;
    }

    public static int powerTwo(int number) {
        return number * number ;
    }

    public static double powerTwo(double number) {
        return number * number;
    }

    public static void greetUser() throws IOException {
        System.out.println("Hello, what's your name?");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Hello " + br.readLine() + "!");
    }

    // --- INTERMEDIATE --- //

    public static String getNumberName(int number) {

        if(Math.abs(number) > 10) {
            throw new InvalidParameterException("number must be between 0 and 10");
        }

        String[] numberNames = {"Null", "Eins", "Zwei", "Drei", "Vier", "Fünf", "Sechs", "Sieben", "Acht", "Neun", "Zehn"};

        String output = "";
        int index = number;
        if(number < 0) {
            output += "Minus ";
            index = index * -1;
        }

        output = output + numberNames[index];

        return output;
    }

    public static void printSpecial100(){
        for(int i = 1; i <= 100; i++){
            String output = "";

            if(i % 3 == 0) {
                output += "#";
            }
            if (i % 5 == 0) {
                output += "$";
            }

            output = output + i;

            if(i % 10 == 0) {
                output += "\n";
            }else {
                output += " ";
            }

            System.out.print( output);
        }
    }

    public static String[] collectInputs() throws IOException {
        System.out.println("Enter any number of Strings. Enter 'quit' to quit.");

        String[] inputs = new String[10];
        int index = 0;
        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();
            if(input.equals("quit")){
                break;
            }

            inputs[index] = input;
            ++index;
            printAll(inputs);
            if((index + 1) % 10 == 0){
                String[] temp = new String[inputs.length + 10];
                System.arraycopy(inputs, 0, temp, 0, inputs.length);
                inputs = temp;
            }
        }
        return inputs;
    }

    // --- EXPERT --- //

    public static String stringReverse(String s){
        // StringBuilder output = new StringBuilder(s);
        // output.reverse();
        StringBuilder output = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--){
            output.append(s.charAt(i));
        }
        return output.toString();
    }

    public static void sortIntArray(int[] array){
        // Arrays.sort(array);

        if(array.length < 2){
            return;
        }

        for(int i = 0; i < array.length - 1; ++i){
            for(int j = i + 1; j < array.length; ++j){
                if(array[i] > array[j]){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }


    public static String[] splitComma(String s){
        //return s.split(",");
        int countStrings = 1;
        for(char c : s.toCharArray()){
            if(c == ','){
                ++countStrings;
            }
        }
        String[] array = new String[countStrings];
        StringBuilder curr = new StringBuilder();
        int index = 0;
        for(int i = 0; i < s.length(); ++i){
            if(s.charAt(i) == ','){
                array[index] = curr.toString();
                curr = new StringBuilder();
                ++index;
                continue;
            }
            curr.append(s.charAt(i));
        }
        array[index] = curr.toString();
        return array;
    }

    public static int quersumme(int number){
        int multiplikator = 1;
        String ziffern = "" + number;
        if(number < 0){
            multiplikator = -1;
        }
        int sum = 0;
        for(char ziffer :  ziffern.toCharArray()){
            if(!(ziffer == '-')){
                sum += (ziffer - '0');
            }
        }
        return multiplikator * sum;
    }

    enum NUMERALS {
        roman1000("M", 1000),
        roman500("D", 500),
        roman100("C", 100),
        roman50("L", 50),
        roman10("X", 10),
        roman5("V", 5),
        roman1("I", 1);

        final int number;
        final String numeral;

        NUMERALS(String numeral, int number){
            this.number = number;
            this.numeral = numeral;
        }

        public int getNumber() {
            return number;
        }
        public String getNumeral() {
            return numeral;
        }
    }

    static int romanNumeralsHelper(NUMERALS numeral_middle, NUMERALS higherNumeral, NUMERALS lowerNumeral,StringBuilder builder, int currentNumber){
        String toAdd = "";
        switch(currentNumber / lowerNumeral.getNumber()){
            case 9: builder.append(lowerNumeral.getNumeral()); builder.append(higherNumeral.getNumeral()); currentNumber -= (9 * lowerNumeral.getNumber()); break;
            case 8: toAdd += lowerNumeral.getNumeral(); currentNumber -= lowerNumeral.getNumber();
            case 7: toAdd += lowerNumeral.getNumeral(); currentNumber -= lowerNumeral.getNumber();
            case 6: toAdd += lowerNumeral.getNumeral(); currentNumber -= lowerNumeral.getNumber();
            case 5: builder.append(numeral_middle.getNumeral()); builder.append(toAdd); currentNumber -= numeral_middle.getNumber(); break;
            case 4: builder.append(lowerNumeral.getNumeral()); builder.append(numeral_middle.getNumeral()); currentNumber -= (4 * lowerNumeral.getNumber()); break;
            case 3: builder.append(lowerNumeral.getNumeral()); currentNumber -= lowerNumeral.getNumber();
            case 2: builder.append(lowerNumeral.getNumeral()); currentNumber -= lowerNumeral.getNumber();
            case 1: builder.append(lowerNumeral.getNumeral()); currentNumber -= lowerNumeral.getNumber(); break;
        }

        return currentNumber;
    }

    static int romanNumeralsHelper1000(StringBuilder builder, int currentNumber){
        switch(currentNumber / NUMERALS.roman1000.getNumber()){
            case 3: builder.append(NUMERALS.roman1000.getNumeral()); currentNumber -= NUMERALS.roman1000.getNumber();
            case 2: builder.append(NUMERALS.roman1000.getNumeral()); currentNumber -= NUMERALS.roman1000.getNumber();
            case 1: builder.append(NUMERALS.roman1000.getNumeral()); currentNumber -= NUMERALS.roman1000.getNumber(); break;
        }

        return currentNumber;
    }

    public static String romanNumerals(int number){

        int tmp = number;
        StringBuilder result = new StringBuilder();
        tmp = romanNumeralsHelper1000(result, tmp);
        tmp = romanNumeralsHelper(NUMERALS.roman500, NUMERALS.roman1000,NUMERALS.roman100, result, tmp);
        tmp = romanNumeralsHelper(NUMERALS.roman50, NUMERALS.roman100,NUMERALS.roman10, result, tmp);
        romanNumeralsHelper(NUMERALS.roman5, NUMERALS.roman10,NUMERALS.roman1, result, tmp);
        return result.toString();
    }

    public static void main(String[] args) throws IOException {

        Random rand  = new Random();

        // -- Maven -- //

        String asciiArt1 = FigletFont.convertOneLine("Hallo Welt!");
        System.out.println(asciiArt1);

        // --- NOVICE --- //

        System.out.println(FigletFont.convertOneLine(" // --- NOVICE --- // " ));

        printLoop("Darian", 5);
        System.out.println("8 more than 0: " + isOverZero(8));
        System.out.println("-8.7 more than 0: " + isOverZero(-8.7));
        System.out.println("8 power 2: " + powerTwo(8));
        System.out.println("-8.7 power 2: " + powerTwo(-8.7));
        greetUser();

        System.out.println();

        // --- INTERMEDIATE --- //

        System.out.println(FigletFont.convertOneLine(" // --- INTERMEDIATE --- // " ));

        System.out.println(getNumberName(rand.nextInt(11)));
        System.out.println(getNumberName(rand.nextInt(11) * -1));
        printSpecial100();
        System.out.println(Arrays.toString(collectInputs()));

        // --- EXPERT --- //

        System.out.println(FigletFont.convertOneLine(" // --- EXPERT --- // " ));

        System.out.println(stringReverse("Hallo Welt!"));

        System.out.println(Arrays.toString(splitComma("Hallo,Welt!,Jo!")));

        int[] a = {6, 2, 8, 3, 9, 6};
        sortIntArray(a);
        System.out.println(Arrays.toString(a));

    }
}
