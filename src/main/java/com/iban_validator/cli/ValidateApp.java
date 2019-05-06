package com.iban_validator.cli;

import com.iban_validator.validator.Validator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class ValidateApp {

    private Validator validator;

    public ValidateApp(Validator validator) {
        this.validator = validator;
    }

    /**
     * Method used to validate list of IBAN code from file
     * Creates new file with same name and extension .out with results
     * @param fileLocation file location containing list of IBAN code
     */
    public void validateFromFile(String fileLocation) {

        try (BufferedReader br = Files.newBufferedReader(Paths.get(fileLocation))) {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileLocation + ".out"));

            String line;
            while ((line = br.readLine()) != null) {
                writer.write(validator.getValidatedIbans(line).toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method for validating single IBAN, prints the result to console
     * @param iban IBAN as a string
     */
    public void validateFromString(String iban) {
        System.out.println(validator.getValidatedIbans(iban).getIsValid());
    }
}
