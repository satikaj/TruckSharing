package com.example.trucksharing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.trucksharing.databinding.ActivityHomeBinding;
import com.example.trucksharing.databinding.ActivityMyOrdersBinding;
import com.example.trucksharing.ui.OrderListAdapter;
import com.example.trucksharing.ui.OrderViewModel;

public class MyOrdersActivity extends AppCompatActivity {

    ActivityMyOrdersBinding binding;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyOrdersBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbarMyOrder);
        getSupportActionBar().setTitle("");

        Intent usernameIntent = getIntent();
        username = usernameIntent.getStringExtra("username");

        RecyclerView recyclerView = binding.myOrderRV;
        final OrderListAdapter adapter = new OrderListAdapter(new OrderListAdapter.OrderDiff());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Ensure playlist data is up to date
        OrderViewModel orderViewModel = new ViewModelProvider(this).get(OrderViewModel.class);
        orderViewModel.getMyOrders(username).observe(this, orders -> {
            adapter.submitList(orders);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_home) {
            Intent homeIntent = new Intent(MyOrdersActivity.this, HomeActivity.class);
            homeIntent.putExtra("username", username);
            startActivity(homeIntent);
            return true;
        } else if (id == R.id.action_account) {
            return true;
        } else if (id == R.id.action_orders) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}