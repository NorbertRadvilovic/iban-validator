package com.iban_validator.soap;

import com.iban_validator.helper.Tokenizer;
import com.iban_validator.iban.Iban;
import com.iban_validator.iban_data.IbanDataFromUrl;
import com.iban_validator.validator.Validator;

import javax.jws.WebService;
import java.util.Arrays;

//Service Implementation
@WebService(endpointInterface = "com.iban_validator.soap.SoapValidator")
public class SoapValidatorImpl implements SoapValidator {

    @Override
    public String verifyIBANList(String input) {
        IbanDataFromUrl ibanData = new IbanDataFromUrl();
        Validator validator = new Validator(ibanData);
        Iban[] validatedIbans = validator.getValidatedIbans(Tokenizer.tokenize(input));
        String result = Arrays.toString(validatedIbans);
        return result.substring(1, result.length() - 1);
    }

}