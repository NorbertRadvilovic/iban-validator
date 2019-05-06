package com.iban_validator.helper;

import com.google.gson.Gson;
import com.iban_validator.iban.Iban;
import com.iban_validator.iban.IbanInterface;

/**
 * Helper class for parsing and generating JSON
 */
public class JsonHelper {

    /**
     * Parses JSON string and produces array of IBAN objects
     * @param json String containing IBAN objects
     * @return array of IBAN objects
     */
    public static Iban[] jsonToIbanArray(String json) {
        Gson gson = new Gson();
        Iban[] ibans = gson.fromJson(json, Iban[].class);
        return ibans;
    }

    /**
     * Generates JSON string from array of IBAN objects
     * @param ibanArray array of IBAN objects
     * @return JSON string with IBAN objects
     */
    public static String ibanArrayToJson(IbanInterface[] ibanArray) {
        Gson gson = new Gson();
        String json = gson.toJson(ibanArray);
        return json;
    }

    /**
     * Generates JSON string from single IBAN object
     * @param iban IBAN object
     * @return JSON string with single IBAN object
     */
    public static String ibanToJson(IbanInterface iban) {
        Gson gson = new Gson();
        String json = gson.toJson(iban);
        return json;
    }
}
