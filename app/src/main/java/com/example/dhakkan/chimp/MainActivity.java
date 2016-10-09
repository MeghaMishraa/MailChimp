package com.example.dhakkan.chimp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class MainActivity extends AppCompatActivity {
    public RecyclerView listRecyclerView;
    public List<ContactList> contactList;
    public String contact;
    private ListViewAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        listRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us13.api.mailchimp.com/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MailchimpService mailchimpService = retrofit.create(MailchimpService.class);
        Call<ListResponse> call = mailchimpService.fetchLists("189ed99a1fee2177a39326257476d520-us13");

       call.enqueue(new Callback<ListResponse>() {
    @Override
    public void onResponse(Call<ListResponse> call, Response<ListResponse> response) {
       for (int i = 0; i < response.body().getContactLists().size(); i++) {
            contactList = response.body().getContactLists();
            adapter = new ListViewAdapter(contactList);

            listRecyclerView.setAdapter(adapter);
//      contact = response.body().getContactLists().get(i).getId();

//         Log.d("CodeKamp", response.body().getContactLists().get(0).getId());

    }}

    @Override
    public void onFailure(Call<ListResponse> call, Throwable t) {
        Log.d("CodeKamp", t.getMessage());

        t.printStackTrace();

    }
       });

    }

}

//decorated design pattern
