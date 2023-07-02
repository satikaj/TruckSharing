package com.example.trucksharing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.trucksharing.databinding.ActivityNewOrderBinding;

public class NewOrderActivity extends AppCompatActivity {

    ActivityNewOrderBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewOrderBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


    }
}