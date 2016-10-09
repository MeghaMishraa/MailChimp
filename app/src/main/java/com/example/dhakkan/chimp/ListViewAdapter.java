package com.example.dhakkan.chimp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Dhakkan on 7/6/2016.
 */
public class ListViewAdapter extends RecyclerView.Adapter<ListViewHolder> {

    public List<ContactList> contactList;


    public ListViewAdapter(List<ContactList> contactList) {
        this.contactList = contactList;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.simplerow, null);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
//    holder.mlist=this.contactList.get(position);

        if (position % 2 == 0)
            holder.titleTextView.setBackgroundColor(Color.parseColor("#FFF9C4"));
        else
            holder.titleTextView.setBackgroundColor(Color.parseColor("#FAFAFA"));
        holder.titleTextView.setText(contactList.get(position).getName());
        this.contactList.get(position);
//        holder.bind();
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }
}
//liquid floating button
//clans floating action button
//Drawer layout
//view pages
//fragment state viewpager