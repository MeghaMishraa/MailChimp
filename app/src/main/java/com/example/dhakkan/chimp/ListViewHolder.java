package com.example.dhakkan.chimp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;


/**
 * Created by Dhakkan on 7/6/2016.
 */

public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public EditText titleTextView;
    Context context;
    public  ContactList contactList;


//    public  List<ContactList> contactLists;
    public ListViewHolder(View itemView) {
        super(itemView);
        titleTextView = (EditText)itemView.findViewById(R.id.edittext);
        context=itemView.getContext();

        titleTextView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent intent = Second_Page.newIntent(context,this.contactList.getId().toString());
        context.startActivity(intent);
    }
}








