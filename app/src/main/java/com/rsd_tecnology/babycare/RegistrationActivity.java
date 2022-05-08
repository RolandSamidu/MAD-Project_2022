package com.rsd_tecnology.babycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegistrationActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;

    private Button register;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        register = findViewById(R.id.register);

        auth = FirebaseAuth.getInstance();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_username = username.getText().toString();
                String txt_password = password.getText().toString();

                if (TextUtils.isEmpty(txt_username) || TextUtils.isEmpty(txt_password)){
                    Toast.makeText(RegistrationActivity.this, "Empty Credentials", Toast.LENGTH_SHORT).show();
                }else if (txt_password.length() < 6){
                    Toast.makeText(RegistrationActivity.this, "Password too short!", Toast.LENGTH_SHORT).show();
                }else{
                    registerUser(txt_username, txt_password);
                }
            }
        });
    }

    private void registerUser(String username, String password) {

        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(RegistrationActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(RegistrationActivity.this, "Registering User Successfully", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(RegistrationActivity.this, "Registering failed!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}