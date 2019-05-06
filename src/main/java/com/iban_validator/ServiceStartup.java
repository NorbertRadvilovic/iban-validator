package com.iban_validator;

import com.iban_validator.rest.RestValidatorStartup;
import com.iban_validator.soap.SoapValidatorPublisher;

/**
 * Class for initiating both SOAP and REST services
 */
public class ServiceStartup {


    public static void main(String[] args) {
        SoapValidatorPublisher soap = new SoapValidatorPublisher();
        RestValidatorStartup rest = new RestValidatorStartup();
        soap.start();
        rest.start();
    }
}
