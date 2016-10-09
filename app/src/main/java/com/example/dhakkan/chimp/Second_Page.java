package com.example.dhakkan.chimp;

import android.content.Context;
import android.content.Intent;
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

public class Second_Page extends AppCompatActivity {
    private static final String ID_EXTRA = "id";
    public RecyclerView mRecyclerView;
    private List<Contact> contacts;
    private SubscriberViewAdapter adapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_row);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview2);
        Intent intent = getIntent();
      String received_Id = intent.getStringExtra(ID_EXTRA);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://us13.api.mailchimp.com/2.0/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        MailchimpService mailchimpService = retrofit.create(MailchimpService.class);


        Call<ContactResponse> call1 = mailchimpService.fetchContacts("189ed99a1fee2177a39326257476d520-us13", received_Id);

        call1.enqueue(new Callback<ContactResponse>() {
            @Override
            public void onResponse(Call<ContactResponse> call, Response<ContactResponse> response) {
                for (int i = 0; i < response.body().getContacts().size(); i++) {
                    contacts = response.body().getContacts();
                    adapter1 = new SubscriberViewAdapter(contacts);

                    mRecyclerView.setAdapter(adapter1);


                }
            }

            @Override
            public void onFailure(Call<ContactResponse> call, Throwable t) {
                Log.d("CodeKamp", t.getMessage());
                t.printStackTrace();
            }
        });
    }

    public static Intent newIntent(Context context, String id) {
        Intent intent = new Intent(context, Second_Page.class);
        intent.putExtra(ID_EXTRA, id);
        return intent;

    }
}

