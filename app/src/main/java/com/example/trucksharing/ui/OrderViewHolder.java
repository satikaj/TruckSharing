package com.example.trucksharing.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.trucksharing.R;

class OrderViewHolder extends RecyclerView.ViewHolder {
    private final TextView itemTitle;
    private final TextView itemDesc;

    private OrderViewHolder(View itemView) {
        super(itemView);
        itemTitle = itemView.findViewById(R.id.itemTitle);
        itemDesc = itemView.findViewById(R.id.itemDesc);
    }

    public void bind(String title, String desc) {
        itemTitle.setText(title);
        itemDesc.setText(desc);
    }

    static OrderViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }
}
