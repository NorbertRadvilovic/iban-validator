package com.iban_validator.rest;

import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class RestValidatorStartup {

    private final static int port = 9998;
    private final static String host = "http://localhost/";

    public void start() {
        URI baseUri = UriBuilder.fromUri(host).port(port).build();
        ResourceConfig config = new ResourceConfig(RestValidator.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
    }
}