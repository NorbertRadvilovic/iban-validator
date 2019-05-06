package com.iban_validator;

import com.iban_validator.cli.ValidateApp;
import com.iban_validator.iban_data.IbanDataFromUrl;
import com.iban_validator.validator.Validator;

/**
 * Command line application for validating IBAN numbers
 */
public class CliValidator {

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Parameter is required\n" +
                    "usage: CliValidator iban_string\n" +
                    "CliValidator -i input.txt");
            return;
        }
        IbanDataFromUrl ibanData = new IbanDataFromUrl();
        Validator validator = new Validator(ibanData);
        ValidateApp app = new ValidateApp(validator);
        if (args[0].equals("-i")) {
            if (!args[1].isEmpty()) {
                app.validateFromFile(args[1]);
            }
        }

        app.validateFromString(args[0]);
    }


}
