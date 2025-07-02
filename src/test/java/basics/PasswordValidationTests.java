package basics;

import org.example.basics.PasswordValidation;
import org.junit.Test;

public class PasswordValidationTests {

    @Test
    public void passwordValidationTest(){

        // No number
        String noNumber = "AaPPP!olmk";
        // No Upper Case
        String noUC = "123äbc_lolxd";
        // No Lower Case
        String noLC = "OHA1WOW9-KRASS3ÖH";
        // No Special Character
        String noSC = "OHA1WOoW9KRASS3ÖH";

        // Common passwords
        String mcPassword = "$HEX[687474703a2f2f616473]";
        String mcPassword2 = "ka_dJKHJsy6";

        // Valid passwords
        String valid1 = "nia#+ÜLL22emd";
        String valid2 = "mkncn2ANQ_po00";
        String valid3 = "Ökr0237{mhfÄ";
        String valid4 = "nia;ÜLL22emd";

        assert(PasswordValidation.validate(valid1));
        assert(PasswordValidation.validate(valid2));
        assert(PasswordValidation.validate(valid3));
        assert(PasswordValidation.validate(valid4));

        assert(!PasswordValidation.validate(noNumber));
        assert(!PasswordValidation.validate(noUC));
        assert(!PasswordValidation.validate(noLC));
        assert(!PasswordValidation.validate(noSC));
        assert(!PasswordValidation.validate(mcPassword));
        assert(!PasswordValidation.validate(mcPassword2));

    }

    @Test
    public void passwordGeneratorTest(){
        assert(PasswordValidation.validate(PasswordValidation.generateRandomPassword()));
    }
}
