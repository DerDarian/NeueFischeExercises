package basics;

import org.example.Main;
import org.example.basics.Bonusaufgaben;
import org.junit.Test;

import java.util.Arrays;

import static org.example.basics.Bonusaufgaben.*;

public class BonusaufgabenTests {

    // NOVICE

    @Test
    public void isOverZeroTest(){

        final int ZERO = 0;
        final int MINUS = -1;
        final int PLUS = 1;

        final double ZERO_D = 0.0;
        final double MINUS_D = -0.00001;
        final double PLUS_D = 0.00001;

        assert(!Bonusaufgaben.isOverZero(ZERO));
        assert(!Bonusaufgaben.isOverZero(MINUS));
        assert(Bonusaufgaben.isOverZero(PLUS));

        assert(!Bonusaufgaben.isOverZero(ZERO_D));
        assert(!Bonusaufgaben.isOverZero(MINUS_D));
        assert(Bonusaufgaben.isOverZero(PLUS_D));

    }

    @Test
    public void powerTwoTest(){
        assert(Bonusaufgaben.powerTwo(0) == 0);
        assert(Bonusaufgaben.powerTwo(1) == 1);
        assert(Bonusaufgaben.powerTwo(-1) == 1);
        assert(Bonusaufgaben.powerTwo(8) == 64);
        assert(Bonusaufgaben.powerTwo(-8) == 64);

        assert(Bonusaufgaben.powerTwo(0.0) == 0.0);
        assert(Bonusaufgaben.powerTwo(1.0) == 1.0);
        assert(Bonusaufgaben.powerTwo(-1.0) == 1.0);
        assert(Bonusaufgaben.powerTwo(1.5) == 2.25);
        assert(Bonusaufgaben.powerTwo(-1.5) == 2.25);
    }

    // EXPERT

    @Test
    public void reverseStringTest(){

        String str = "Hallo Welt!";
        String expected = "!tleW ollaH";

        assert(stringReverse(str).equals(expected));
    }

    @Test
    public void splitCommaTest(){
        String str = "Hallo,Welt!,Jo!";
        String[] expected = {"Hallo","Welt!","Jo!"};
        assert(Arrays.equals(splitComma(str), expected));
    }

    @Test
    public void romanNumeralsTest(){
        final String ROMAN_593 = "DXCIII";
        final String ROMAN_1093 = "MXCIII";
        final String ROMAN_2566 = "MMDLXVI";
        final String ROMAN_103 = "CIII";
        final String ROMAN_17 = "XVII";

        assert(romanNumerals(593).equals(ROMAN_593));
        assert(romanNumerals(103).equals(ROMAN_103));
        assert(romanNumerals(17).equals(ROMAN_17));
        assert(romanNumerals(2566).equals(ROMAN_2566));
        assert(romanNumerals(1093).equals(ROMAN_1093));
    }

    @Test
    public void quersummeTest(){
        assert(quersumme(0) == 0);
        assert(quersumme(66) == 12);
        assert(quersumme(-66) == -12);
        assert(quersumme(66051) == 18);
        assert(quersumme(-66051) == -18);
    }

    @Test
    public void sortIntArrayTest(){
        int[] arr = {6, 2, 8, 3, 9, 6};
        int[] arr_check = {2, 3, 6, 6, 8, 9};
        sortIntArray(arr);
        assert(Arrays.equals(arr, arr_check));
    }
}
