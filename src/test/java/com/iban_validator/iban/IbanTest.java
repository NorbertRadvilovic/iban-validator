package com.iban_validator.iban;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IbanTest {

    @Test
    void testGetCountryCode()
    {
        Iban iban = new Iban("LT517044077788877777");
        assertEquals(iban.getCountryCode(), "LT");
    }

    @Test
    void testGetLength()
    {
        Iban iban = new Iban("LT517044077788877777");
        assertEquals(iban.getLenght(), 20);
    }
}
