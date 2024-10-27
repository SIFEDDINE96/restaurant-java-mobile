package org.javaphile.restaurant;

// LoginActivity.java

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText, passwordEditText;
    private CheckBox rememberMeCheckBox;
    private FirebaseAuth mAuth;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // Initialiser Firebase Auth
        // mAuth = FirebaseAuth.getInstance();

        // Récupérer les vues
        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.password);
        rememberMeCheckBox = findViewById(R.id.rememberMe);
        Button loginButton = findViewById(R.id.loginButton);
        loginButton.setEnabled(true);

        // Handle login button click
        loginButton.setOnClickListener(v -> {
            Log.d("LoginActivity", "Clicked");
            // Redirect to MenuCategoriesActivity
            Intent intent = new Intent(LoginActivity.this, MenuCategoriesActivity.class);
            startActivity(intent);
            finish(); // Optional: Finish this activity to prevent going back to the login screen
        });

    }

    // Vérifier si les informations de connexion sont déjà enregistrées
    private void checkRememberedLogin() {

    }
}
