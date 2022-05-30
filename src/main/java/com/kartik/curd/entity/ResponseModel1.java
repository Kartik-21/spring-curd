package com.kartik.curd.entity;

import org.springframework.http.HttpStatus;

public class ResponseModel1<T> extends ResponseModel<T> {
    private String name;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    private User user;

    public ResponseModel1(T data, HttpStatus status, String name) {
        super(data, status);
        this.name = name;
        this.user =new User("Kartik","Jain");
    }

    public ResponseModel1() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


class User {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
