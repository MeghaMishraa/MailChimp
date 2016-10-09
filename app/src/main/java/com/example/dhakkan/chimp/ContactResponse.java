package com.example.dhakkan.chimp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ContactResponse {

    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("data")
    @Expose
    private List<Contact> contacts = new ArrayList<Contact>();

    public Integer getTotal() {
        return total;
    }


    public List<Contact> getContacts() {
        return contacts;
    }
}


