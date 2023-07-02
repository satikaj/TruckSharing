package com.example.trucksharing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OrderFragment extends Fragment {

    private static final String ORDERS = "orders";
    private static final String POSITION = "position";

    private String orders;
    private String position;

    public OrderFragment() {
        // Required empty public constructor
    }

    public static OrderFragment newInstance(String orders, String position) {
        OrderFragment fragment = new OrderFragment();
        Bundle args = new Bundle();
        args.putString(ORDERS, orders);
        args.putString(POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            orders = getArguments().getString(ORDERS);
            position = getArguments().getString(POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
}