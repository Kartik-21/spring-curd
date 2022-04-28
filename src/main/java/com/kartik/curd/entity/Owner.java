package com.kartik.curd.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class Owner {

    private String ownerName;

    private String ownerMobileNumber;

}
