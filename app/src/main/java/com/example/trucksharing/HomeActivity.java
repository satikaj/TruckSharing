package com.example.trucksharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.trucksharing.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setTitle("");

        Intent usernameIntent = getIntent();
        username = usernameIntent.getStringExtra("username");
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
            return true;
        } else if (id == R.id.action_account) {
            return true;
        } else if (id == R.id.action_orders) {
            Intent myOrderIntent = new Intent(HomeActivity.this, MyOrdersActivity.class);
            myOrderIntent.putExtra("username", username);
            startActivity(myOrderIntent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}