package com.iban_validator.soap;

import javax.xml.ws.Endpoint;

//Endpoint publisher
public class SoapValidatorPublisher {

    private final static int port = 9999;
    private final static String host = "http://localhost";
    private final static String endpoint = "/soap";

    public void start() {
        Endpoint.publish(host+":"+port+endpoint, new SoapValidatorImpl());
    }

}