package com.iban_validator.iban_data;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Class that gets IBAN data from single JSON file containing information about each country IBAN
 */
public class IbanDataFromUrl implements IbanDataInterface {

    HashMap<String, Integer> IbanLenghts = new HashMap<String, Integer>();

    /**
     * Creates object by populating hashMap with country data from JSON at specific URL
     */
    public IbanDataFromUrl() {
        Gson gson = new Gson();
        try {
            URL url = new URL("https://gist.githubusercontent.com/azakordonets/9b92b17eb385fcf32c6d7cf6a66c0e83/raw/6007f8b54e0b1e6c4dd71139f69f5f5ac358a278/iban.json");
            InputStream inputStream = url.openStream();
            InputStreamReader reader = new InputStreamReader(inputStream);
            Values values = gson.fromJson(reader, Values.class);
            populateHashMap(values);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Populates hashMap with data about each country
     * @param countryDataList List of countryData objects
     */
    private void populateHashMap(Values countryDataList) {
        for (CountryData countryData : countryDataList.values) {
            IbanLenghts.put(countryData.code, countryData.length);
        }
    }

    @Override
    public boolean isValidCountry(String countryCode) {
        return IbanLenghts.containsKey(countryCode);
    }

    @Override
    public int getLenght(String countryCode) {
        return IbanLenghts.get(countryCode);
    }
}
