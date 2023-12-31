package com.example.trucksharing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Toast;

import com.example.trucksharing.databinding.ActivityMainBinding;
import com.example.trucksharing.room.AppDatabase;
import com.example.trucksharing.room.UserDao;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = binding.username.getText().toString();
                String password = binding.password.getText().toString();

                AppDatabase db = AppDatabase.getDatabase(getApplication());
                UserDao userDao = db.userDao();
                AppDatabase.databaseWriteExecutor.execute(() -> {
                    String truePassword = userDao.getUserPassword(username);
                    // Login only if the credentials are valid and correct
                    if (password.equals(truePassword)) {
                        Intent loginIntent = new Intent(MainActivity.this, HomeActivity.class);
                        loginIntent.putExtra("username", username);
                        startActivity(loginIntent);
                    } else {
                        Looper.prepare();
                        Toast.makeText(MainActivity.this, "Wrong login credentials. Please try again.", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        binding.signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
    }
}