# iban-validator

Application for validating IBAN numbers.

## Getting Started

Application has 2 modes of operation:
1. Command line app `CliValidator.java` for validating single IBAN number as an input, or file containing a list of IBAN numbers
with input: `-i input.txt`.
2. SOAP and Rest services. They can be started by running ServiceStartup. SOAP service is available at
http://localhost:9999/soap/?wsdl,  and REST at http://localhost:9998/rest

### Example SOAP request

Request:
```
<Envelope xmlns="http://schemas.xmlsoap.org/soap/envelope/">
    <Body>
        <verifyIBANList xmlns="http://soap.iban_validator.com/">
            <arg0 xmlns="">AA051245445454552117989</arg0>
        </verifyIBANList>
    </Body>
</Envelope>
```

Response:
```
<?xml version="1.0" ?>
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
    <S:Body>
        <ns2:verifyIBANListResponse xmlns:ns2="http://soap.iban_validator.com/">
            <return>AA051245445454552117989;false</return>
        </ns2:verifyIBANListResponse>
    </S:Body>
</S:Envelope>
```

### Example REST requests
GET http://localhost:9998/rest?iban=CC051245445454552117989

Response:
```
{
    "iban": "CC051245445454552117989",
    "valid": false
}
```

POST Request http://localhost:9998/rest
```
[
    {
        "iban": "AA051245445454552117989"
    },
    {
        "iban": "LT647044001231465456"
    }
]
```

Reponse:
```
[
    {
        "iban": "AA051245445454552117989",
        "valid": false
    },
    {
        "iban": "LT647044001231465456",
        "valid": true
    }
]
```
