package com.iban_validator.helper;

/**
 * Class used by SOAP service to tokenize input and deTokenize result
 */
public class Tokenizer {

    /**
     * Tokenizes string based on space symbol
     * Removes new line and tab characters
     * @param input String containing one or more strings, separated by space
     * @return array of String, each containing single string
     */
    public static String[] tokenize(String input) {
        input = input.replaceAll("\t", "");
        input = input.replaceAll("\n", "");
        if (input.replaceAll("\\s+", "").length() == 0) {
            return new String[0];
        }
        return input.split("\\s+");
    }

    /**
     * Converts array of strings into single string with space being the delimeter
     * @param input array of Strings
     * @return Single string with all elements from array in it separated by space
     */
    public static String deTokenize(String[] input) {
        StringBuilder result = new StringBuilder();
        for (String singleResult : input) {
            result.append(singleResult + " ");
        }
        //Remove trailing space
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }

}
