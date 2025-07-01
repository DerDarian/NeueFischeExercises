package org.example.basics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PasswordValidation {
    final private static int PASSWORD_LENGTH_MIN = 8;
    final private static String REGEX_AT_LEAST_ONE_NUMBER = "\\d+";
    final private static String REGEX_AT_LEAST_ONE_UC = "[A-Z]+";
    final private static String REGEX_AT_LEAST_ONE_LC = "[a-z]+";
    final private static String REGEX_AT_LEAST_ONE_UC_UML = "[Ä-Ü]+";
    final private static String REGEX_AT_LEAST_ONE_LC_UML = "[ä-ü]+";

    final private static String[] MOST_COMMON_PASSWORDS = getMostCommonPasswords();

    public static String[] getMostCommonPasswords(){
        List<String> mostCommonPasswords = new ArrayList<>();
        File file = new File("MostCommonPasswords.txt");
        try {
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                mostCommonPasswords.add(reader.nextLine());
            }
            reader.close();
            return mostCommonPasswords.toArray(new String[0]);
        } catch(FileNotFoundException e) {
            e.printStackTrace();
            return new String[0];
        }
    }
}
