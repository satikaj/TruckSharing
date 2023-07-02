package com.example.trucksharing.ui;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.trucksharing.room.Order;

public class OrderListAdapter extends ListAdapter<Order, OrderViewHolder> {

    public OrderListAdapter(@NonNull DiffUtil.ItemCallback<Order> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return OrderViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(OrderViewHolder holder, int position) {
        Order current = getItem(position);
        holder.bind(current.getVehicleType(), current.getGoodType());
    }

    public static class OrderDiff extends DiffUtil.ItemCallback<Order> {

        @Override
        public boolean areItemsTheSame(@NonNull Order oldItem, @NonNull Order newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Order oldItem, @NonNull Order newItem) {
            return oldItem.getVehicleType().equals(newItem.getVehicleType());
        }
    }
}
