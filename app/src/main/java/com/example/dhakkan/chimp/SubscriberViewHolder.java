package com.example.dhakkan.chimp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Dhakkan on 7/7/2016.
 */
public class SubscriberViewHolder extends RecyclerView.ViewHolder {
    public TextView mRow;

    public SubscriberViewHolder(View itemView) {
        super(itemView);
        mRow = (TextView)itemView.findViewById(R.id.textview);

    }
}
