package com.kartik.curd.entity.compound_key;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Market implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "currencyName", referencedColumnName = "currencyName"), @JoinColumn(
            name = "country", referencedColumnName = "country"
    )})
    private Currency currency;


    public Market() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
