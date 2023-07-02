package com.example.trucksharing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.trucksharing.databinding.ActivitySignUpBinding;
import com.example.trucksharing.room.AppRepository;
import com.example.trucksharing.room.User;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class SignUpActivity extends AppCompatActivity {

    ActivitySignUpBinding binding;
    public static final int PICK_IMAGE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        AppRepository repository = new AppRepository(getApplication());

        binding.choosePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Select image from file picker
                if (ContextCompat.checkSelfPermission(SignUpActivity.this, android.Manifest.permission.READ_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                    Intent selectImageIntent = new Intent(Intent.ACTION_GET_CONTENT);
                    selectImageIntent.setType("image/*");
                    startActivityForResult(selectImageIntent, PICK_IMAGE);
                }
                else {
                    // Ask for permission
                    ActivityCompat.requestPermissions(SignUpActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
                }
            }
        });

        binding.createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fullname = binding.fullname.getText().toString();
                String username = binding.usernameSignup.getText().toString();
                String password = binding.passwordSignup.getText().toString();
                String confirmPass = binding.confirmPassword.getText().toString();
                String phone = binding.phone.getText().toString();

                if (password.equals(confirmPass)) {
                    // Make an account for the new user and log them in
                    repository.insertUser(new User(username, password, fullname, phone));
                    Toast.makeText(SignUpActivity.this, "Account created!", Toast.LENGTH_SHORT).show();

                    Intent signUpIntent = new Intent(SignUpActivity.this, HomeActivity.class);
                    signUpIntent.putExtra("username", username);
                    startActivity(signUpIntent);
                }
                else {
                    Toast.makeText(SignUpActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Replace ImageButton image with selected image
        if (requestCode == PICK_IMAGE && resultCode == RESULT_OK) {
            try {
                InputStream inputStream = getContentResolver().openInputStream(data.getData());
                binding.choosePicture.setImageBitmap(BitmapFactory.decodeStream(inputStream));
                inputStream.close();
            } catch (FileNotFoundException fnf) {
                Log.e("Sign Up Image", "Image file not found.");
            } catch (Exception e) {
                Log.e("Sign Up Image", e.getMessage());
            }
        }
    }
}