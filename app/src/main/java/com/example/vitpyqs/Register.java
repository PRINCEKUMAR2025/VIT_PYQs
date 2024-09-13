package com.example.vitpyqs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText name, email, password;
    ProgressBar progress;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // If user is already logged in, redirect to MainActivity
        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(Register.this, MainActivity.class));
            finish();
        }

        // Initialize UI elements
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        progress = findViewById(R.id.progress);
    }

    public void signup(View view) {
        progress.setVisibility(View.VISIBLE);
        String userName = name.getText().toString();
        String userEmail = email.getText().toString();
        String userPassword = password.getText().toString();

        // Validate inputs
        if (TextUtils.isEmpty(userName)) {
            name.setError("Name Required");
            progress.setVisibility(View.INVISIBLE);
            return;
        }
        if (TextUtils.isEmpty(userEmail)) {
            email.setError("Email Required");
            progress.setVisibility(View.INVISIBLE);
            return;
        }
        if (TextUtils.isEmpty(userPassword)) {
            password.setError("Set your password");
            progress.setVisibility(View.INVISIBLE);
            return;
        }
        if (userPassword.length() < 6) {
            Toast.makeText(this, "Password too short, enter at least 6 characters.", Toast.LENGTH_SHORT).show();
            progress.setVisibility(View.INVISIBLE);
            return;
        }

        // Create user with Firebase Authentication
        auth.createUserWithEmailAndPassword(userEmail, userPassword)
                .addOnCompleteListener(Register.this, task -> {
                    progress.setVisibility(View.INVISIBLE);
                    if (task.isSuccessful()) {
                        // Registration successful
                        Toast.makeText(Register.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Register.this, MainActivity.class));
                        finish();
                    } else {
                        // Registration failed
                        Toast.makeText(Register.this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

    public void signin(View view) {
        // Navigate to Login activity
        startActivity(new Intent(Register.this, Login.class));
    }
}
