package com.iban_validator.iban;

/**
 * Interface for IBAN object with methods needed for their processing
 */
public interface IbanInterface {

    /**
     * @return full IBAN number as a string
     */
    String getIbanString();

    /**
     * @return first 2 characters, symbolising country code
     */
    String getCountryCode();

    /**
     * @return length of the iban string
     */
    int getLenght();

    /**
     * Sets validity of IBAN
     * @param valid true if IBAN is valid, else false
     */
    void setIsValid(boolean valid);

    /**
     * @return returns validity of IBAN
     */
    boolean getIsValid();

    /**
     * @return concatenation of iban string and isValid value with semicolon between them
     */
    String toString();
}
