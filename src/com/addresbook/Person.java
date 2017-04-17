package com.addresbook;


import java.util.Collections;
import java.util.Vector;

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

    public static void sortEntry (Vector<Person> entry) {
        Collections.sort(entry, new PersonComparator());
    }

    static class PersonComparator implements Comparator<Person> {
        public int compare (Person left, Person right) {
            return left.getName_().compareTo(right.getName_());
        }
    }

    private String name_;
    private String number_;
    private String email_;
}


