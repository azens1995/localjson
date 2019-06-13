package com.azens1995.localjsontest;

/**
 * Created by Azens Eklak on 2019-06-13.
 * Ishani Technology Pvt. Ltc
 * azens1995@gmail.com
 */
public class PersonModel {
    private String name;
    private String surname;
    private String email;
    private String poem;


    public PersonModel(String name, String surname, String email, String poem) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.poem = poem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPoem() {
        return poem;
    }

    public void setPoem(String poem) {
        this.poem = poem;
    }

    @Override
    public String toString() {
        return "PersonModel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", poem='" + poem + '\'' +
                '}';
    }
}
