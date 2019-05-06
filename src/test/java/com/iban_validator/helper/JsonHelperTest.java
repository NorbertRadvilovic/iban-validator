package com.iban_validator.helper;

import com.iban_validator.iban.Iban;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JsonHelperTest {

    @Test
    void testJsonToIbanArray1() {
        Iban[] ibanFromJson = JsonHelper.jsonToIbanArray("[{\"iban\": \"CC051245445454552117989\"}]");
        assertEquals(ibanFromJson.length, 1);
        assertEquals(ibanFromJson[0].getIbanString(), "CC051245445454552117989");
    }

    @Test
    void testJsonToIbanArray2() {
        Iban[] ibanFromJson = JsonHelper.jsonToIbanArray("[{\"iban\": \"CC051245445454552117989\"}," +
                "{\"iban\": \"LT647044001231465456\"}]");
        assertEquals(ibanFromJson.length, 2);
        assertEquals(ibanFromJson[0].getIbanString(), "CC051245445454552117989");
        assertEquals(ibanFromJson[1].getIbanString(), "LT647044001231465456");
    }

    @Test
    void testIbanArrayToJson1() {
        Iban[] ibanArray = {new Iban("LT647044001231465456")};
        String json = JsonHelper.ibanArrayToJson(ibanArray);
        assertEquals(json, "[{\"iban\":\"LT647044001231465456\",\"valid\":false}]");
    }

    @Test
    void testIbanArrayToJson2() {
        Iban[] ibanArray = {new Iban("LT647044001231465456"),
                new Iban("CC051245445454552117989")};
        String json = JsonHelper.ibanArrayToJson(ibanArray);
        assertEquals(json, "[{\"iban\":\"LT647044001231465456\",\"valid\":false}," +
                "{\"iban\":\"CC051245445454552117989\",\"valid\":false}]");
    }

    @Test
    void testIbanToJson() {
        Iban iban = new Iban("LT647044001231465456");
        String json = JsonHelper.ibanToJson(iban);
        assertEquals(json, "{\"iban\":\"LT647044001231465456\",\"valid\":false}");
    }
}
