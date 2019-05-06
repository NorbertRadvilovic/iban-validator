package com.iban_validator.rest;

import com.iban_validator.helper.JsonHelper;
import com.iban_validator.iban.Iban;
import com.iban_validator.iban.IbanInterface;
import com.iban_validator.iban_data.IbanDataFromUrl;
import com.iban_validator.validator.Validator;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

@Path("rest")
public class RestValidator {
    public RestValidator() {
        super();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public String postMovieEvent(@Context Request request, String json) {
        IbanDataFromUrl ibanData = new IbanDataFromUrl();
        Validator validator = new Validator(ibanData);
        Iban[] result = validator.getValidatedIbans(JsonHelper.jsonToIbanArray(json));
        return JsonHelper.ibanArrayToJson(result);
    }

    @GET
    @Produces("application/json")
    public String getMovieEvent(@Context UriInfo uri) {
        MultivaluedMap<String, String> queryParams = uri.getQueryParameters();
        IbanDataFromUrl ibanData = new IbanDataFromUrl();
        Validator validator = new Validator(ibanData);
        IbanInterface result = validator.getValidatedIbans(queryParams.get("iban").get(0));
        return JsonHelper.ibanToJson(result);
    }

}