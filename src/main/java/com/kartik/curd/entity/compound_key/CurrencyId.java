package com.kartik.curd.entity.compound_key;

import javax.persistence.Id;
import java.io.Serializable;

public class CurrencyId implements Serializable {

    private String currencyName;

    private String country;

    public CurrencyId(String currencyName, String country) {
        this.currencyName = currencyName;
        this.country = country;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCountry() {
        return country;
    }

    public CurrencyId() {
    }
}
