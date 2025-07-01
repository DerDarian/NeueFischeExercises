package org.example.basics;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Pattern;

public class PasswordValidation {
    final private static int PASSWORD_LENGTH_MIN = 8;
    final private static String REGEX_AT_LEAST_ONE_NUMBER = "[0-9]+";
    final private static String REGEX_AT_LEAST_ONE_UC = "[A-Z]+";
    final private static String REGEX_AT_LEAST_ONE_LC = "[a-z]+";
    final private static String REGEX_AT_LEAST_ONE_UC_UML = "[Ä-Ü]+";
    final private static String REGEX_AT_LEAST_ONE_LC_UML = "[ä-ü]+";
    final private static String REGEX_SPECIAL_CHARACTERS = "[!-\\/]+";
    final private static String REGEX_SPECIAL_CHARACTERS2 = "[:-@]+";
    final private static String REGEX_SPECIAL_CHARACTERS3 = "[\\[-`]+";
    final private static String REGEX_SPECIAL_CHARACTERS4 = "[{-~]+";

    final private static List<String> MOST_COMMON_PASSWORDS = getMostCommonPasswords();

    public static List<String> getMostCommonPasswords(){
        List<String> mostCommonPasswords = new ArrayList<>();
        InputStream is= PasswordValidation.class.getClassLoader().getResourceAsStream("MostCommonPasswords.txt");
        try {
            if(is == null){
                return mostCommonPasswords;
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            while (reader.ready()) {
                mostCommonPasswords.add(reader.readLine());
            }
            reader.close();
        } catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return mostCommonPasswords;
    }

    static boolean validateLength(String password){
        return password.length() >= PASSWORD_LENGTH_MIN;
    }

    static boolean containsSpecialCharacter(String password){
        return matchRegex(password, REGEX_SPECIAL_CHARACTERS) || matchRegex(password, REGEX_SPECIAL_CHARACTERS2) || matchRegex(password, REGEX_SPECIAL_CHARACTERS3) || matchRegex(password, REGEX_SPECIAL_CHARACTERS4);
    }

    static boolean containsUpperCaseLetter(String password){
        return matchRegex(password, REGEX_AT_LEAST_ONE_UC) || matchRegex(password, REGEX_AT_LEAST_ONE_UC_UML);
    }

    static boolean containsLowerCaseLetter(String password){
        return matchRegex(password, REGEX_AT_LEAST_ONE_LC)|| matchRegex(password, REGEX_AT_LEAST_ONE_LC_UML);
    }

    static boolean containsNumber(String password){
        return matchRegex(password, REGEX_AT_LEAST_ONE_NUMBER);
    }

    static boolean isCommonPassword(String password){
        return MOST_COMMON_PASSWORDS.contains(password);
    }

    static boolean matchRegex(String password, String regex){
        Pattern p = Pattern.compile(regex);
        return p.matcher(password).find();
    }

    public static boolean validate(String password){
        return containsNumber(password) && containsLowerCaseLetter(password) && containsUpperCaseLetter(password) && validateLength(password) && containsSpecialCharacter(password) && !isCommonPassword(password);
    }

    public static String generateRandomPassword(){
        final String upper = "ABCDEFGHIJKLMNOPQRSTUVWXYZÄÖÜ";
        final String lower = upper.toLowerCase();
        final String number = "0123456789";
        final String specialCharacters = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";
        final String possibleCharacters = upper + lower + number + specialCharacters;
        Random random = new Random();
        int length = 2 * PASSWORD_LENGTH_MIN + random.nextInt(5);

        StringBuilder passwordBuilder = new StringBuilder();

        for(int i = 0; i < length; i++){
            passwordBuilder.append(possibleCharacters.charAt(random.nextInt(possibleCharacters.length())));
        }
        String password = passwordBuilder.toString();
        if(!containsSpecialCharacter(password)){
            password += specialCharacters.charAt(random.nextInt(specialCharacters.length()));
        }
        if(!containsNumber(password)){
            password += number.charAt(random.nextInt(number.length()));
        }
        if(!containsLowerCaseLetter(password)){
            password += lower.charAt(random.nextInt(lower.length()));
        }
        if(!containsUpperCaseLetter(password)){
            password += upper.charAt(random.nextInt(upper.length()));
        }

        return password;
    }
}
