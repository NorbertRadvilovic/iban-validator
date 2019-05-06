package com.iban_validator.iban;

public class Iban implements IbanInterface {
    private String iban;

    private boolean valid;


    public Iban(String iban) {
        this.iban = iban.replaceAll("\\s", "");
    }

    @Override
    public String getIbanString() {
        return iban;
    }

    @Override
    public String getCountryCode() {
        return iban.substring(0, 2);
    }

    @Override
    public int getLenght() {
        return iban.length();
    }

    @Override
    public void setIsValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean getIsValid() {
        return valid;
    }

    @Override
    public String toString() {
        return iban + ";" + valid;
    }
}
