package com.azens1995.localjsontest;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Azens Eklak on 2019-06-13.
 * Ishani Technology Pvt. Ltc
 * azens1995@gmail.com
 */
public class Data {
    @SerializedName("items")
    private List<PersonModel> personList;

    public List<PersonModel> getPersonList() {
        return personList;
    }

    public void setPersonList(List<PersonModel> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "Data{" +
                "personList=" + personList +
                '}';
    }
}
