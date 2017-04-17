package com.addresbook;


/**
 * Created by USER on 2017-04-15.
 */
public class Person {

    Person (String name, String number, String email) {
        this.name_ = name;
        this.number_ =  number;
        this.email_ = email;
    }

    public String getName_() {
        return name_;
    }

    public String getNumber_() {
        return number_;
    }

    public String getEmail_() {
        return email_;
    }

    private String name_;
    private String number_;
    private String email_;
}
