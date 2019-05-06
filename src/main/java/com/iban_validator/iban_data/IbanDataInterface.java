package com.iban_validator.iban_data;

/**
 * Interface for getting IBAN data for specific country
 */
public interface IbanDataInterface {

    /**
     * @param countryCode 2 capital letter code for country according to ISO 3166-1
     * @return true if country code is valid, false if invalid
     */
    boolean isValidCountry(String countryCode);

    /**
     * @param countryCode 2 capital letter code for country according to ISO 3166-1
     * @return valid length for specific country IBAN number
     */
    int getLenght(String countryCode);
}
