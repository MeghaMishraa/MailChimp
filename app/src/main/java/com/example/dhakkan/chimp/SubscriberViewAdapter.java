package com.example.dhakkan.chimp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Dhakkan on 7/7/2016.
 */
public class SubscriberViewAdapter extends RecyclerView.Adapter<SubscriberViewHolder> {
    public List<Contact> contacts;

    public SubscriberViewAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }


    @Override
    public SubscriberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.next_row, null);
        return new SubscriberViewHolder(view);

    }

    @Override
    public void onBindViewHolder(SubscriberViewHolder holder, int position) {
        if (position % 2 == 0)
            holder.mRow.setBackgroundColor(Color.parseColor("#FFF9C4"));
        else
            holder.mRow.setBackgroundColor(Color.parseColor("#FAFAFA"));
        holder.mRow.setText(contacts.get(position).getEmail());

    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
