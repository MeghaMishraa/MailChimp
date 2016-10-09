package com.example.dhakkan.chimp;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ListResponse {

    @SerializedName("data")
    @Expose
//    for array we make a list.
//    for list of list of intger.
//    private List<List<Integer>> contactlista = new ArrayList<>();
    private List<ContactList> contactLists = new ArrayList<ContactList>();


    public List<ContactList> getContactLists() {
        return contactLists;
    }
}