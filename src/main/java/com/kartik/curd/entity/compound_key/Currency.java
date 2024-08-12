package com.kartik.curd.entity.compound_key;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@IdClass(CurrencyId.class)
public class Currency implements Serializable {


    @Id
    private String currencyName;

    @Id
    private String country;

    private String symbol;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currency", orphanRemoval = true)
    private List<Market> markets = new ArrayList<>();

    public List<Market> getMarkets() {
        return markets;
    }

    public void setMarkets(List<Market> markets) {
        this.markets = markets;
    }

    public Currency() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }
}

