package com.iban_validator.validator;

import com.iban_validator.iban.Iban;
import com.iban_validator.iban_data.IbanDataFromUrl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidatorTest {

    static Validator validator;

    @BeforeAll
    public static void setUpClass() {
        IbanDataFromUrl ibanData = new IbanDataFromUrl();
        validator = new Validator(ibanData);
    }

    @Test
    void testCorrectLtIban1() {
        Iban iban = new Iban("LT647044001231465456");
        assertTrue(validator.isValid(iban));
    }

    @Test
    void testCorrectLtIban2() {
        Iban iban = new Iban("LT517044077788877777");
        assertTrue(validator.isValid(iban));
    }

    @Test
    void testCorrectGbIban() {
        Iban iban = new Iban("GB29NWBK60161331926819");
        assertTrue(validator.isValid(iban));
    }

    @Test
    void testTooShortIban() {
        Iban iban = new Iban("LT65456");
        assertFalse(validator.isValid(iban));
    }

    @Test
    void testTooLongIban() {
        Iban iban = new Iban("LT64704400444551231465456");
        assertFalse(validator.isValid(iban));
    }

    @Test
    void testIncorrectIban1() {
        Iban iban = new Iban("AA051245445454552117989");
        assertFalse(validator.isValid(iban));
    }

    @Test
    void testIncorrectIban2() {
        Iban iban = new Iban("LT227044077788877777");
        assertFalse(validator.isValid(iban));
    }

    @Test
    void testIncorrectIban3() {
        Iban iban = new Iban("CC051245445454552117989");
        assertFalse(validator.isValid(iban));
    }

}