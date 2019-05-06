package com.iban_validator.validator;

import com.iban_validator.iban.Iban;
import com.iban_validator.iban_data.IbanDataInterface;

import java.math.BigInteger;

/**
 * Class for validating IBAN numbers
 */
public class Validator {
    private static final BigInteger BIG_INTEGER_97 = new BigInteger("97");
    private IbanDataInterface ibanData;

    /**
     * Creates Validator with IbanDataInterface for getting IBAN number data
     * @param ibanData
     */
    public Validator(IbanDataInterface ibanData) {
        this.ibanData = ibanData;
    }

    /**
     * Validates single IBAN object
     * @param iban IBAN object to be validated
     * @return validated IBAN object
     */
    public Iban getValidatedIbans(Iban iban) {
        Iban[] ibanArray = new Iban[1];
        ibanArray[0] = iban;
        return validate(ibanArray)[0];
    }

    /**
     * Validates single IBAN string
     * @param ibanString IBAN string to be validated
     * @return validated IBAN object
     */
    public Iban getValidatedIbans(String ibanString) {
        Iban[] ibanArray = new Iban[1];
        ibanArray[0] = new Iban(ibanString);
        return validate(ibanArray)[0];
    }

    /**
     * Validates array of IBAN strings
     * @param ibanStringArray array of IBAN strings
     * @return validated array of IBAN objects
     */
    public Iban[] getValidatedIbans(String[] ibanStringArray) {
        Iban[] ibanArray = new Iban[ibanStringArray.length];
        for (int i = 0; i < ibanStringArray.length; i++) {
            ibanArray[i] = new Iban(ibanStringArray[i]);
        }
        return validate(ibanArray);
    }

    /**
     * Validates array of IBAN objects
     * @param ibanArray array of IBAN objects
     * @return validated array of IBAN objects
     */
    public Iban[] getValidatedIbans(Iban[] ibanArray) {
        return validate(ibanArray);
    }

    /**
     * @param iban IBAN object
     * @return validity of IBAN object
     */
    public boolean isValid(Iban iban) {
        return (isValidCountryCode(iban) &&
                isValidLenght(iban) &&
                isValidChecksum(iban));
    }

    /**
     * Validates array of IBAN objects
     * @param ibanArray array of IBAN objects
     * @return validated IBAN array
     */
    private Iban[] validate(Iban[] ibanArray) {
        for (Iban iban : ibanArray) {
            iban.setIsValid(isValid(iban));
        }
        return ibanArray;
    }

    /**
     * Helper method for validating IBAN number country code
     * @param iban IBAN object
     * @return true if country code is valid
     */
    private boolean isValidCountryCode(Iban iban) {
        return ibanData.isValidCountry(iban.getCountryCode());
    }

    /**
     * Helper method for validating IBAN number length
     * @param iban IBAN object
     * @return true if IBAN length is valid
     */
    private boolean isValidLenght(Iban iban) {
        return iban.getLenght() == ibanData.getLenght(iban.getCountryCode());
    }

    /**
     * Helper method for validating IBAN number checksum
     * Rearanges IBAN by moving first 4 characters to its' end
     * Replacing letters with numbers
     * Calculating mod 97 of that number string
     * Comparing result to 1
     * @param iban IBAN object
     * @return true if checksum is valid
     */
    private boolean isValidChecksum(Iban iban) {
        String rearrangedIban = iban.getIbanString().substring(4) +
                iban.getIbanString().substring(0, 4);
        rearrangedIban = replaceLettersWithNumbers(rearrangedIban);
        BigInteger ibanAsInteger = new BigInteger(rearrangedIban);
        return ibanAsInteger.mod(BIG_INTEGER_97).intValue() == 1;
    }

    /**
     * Helper method for replacing all letters with numeric value
     * @param input String
     * @return input with letters replaced by their numeric value
     */
    private String replaceLettersWithNumbers(String input) {
        StringBuilder result = new StringBuilder();
        for (Character character : input.toCharArray()) {
            result.append(Character.getNumericValue(character));
        }
        return result.toString();
    }
}
