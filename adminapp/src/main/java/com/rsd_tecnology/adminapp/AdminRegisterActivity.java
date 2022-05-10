package com.rsd_tecnology.adminapp;

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

public class AdminRegisterActivity extends AppCompatActivity {
    private Button register;
    private EditText username;
    private EditText password;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_register);

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
                    Toast.makeText(AdminRegisterActivity.this, "Empty Credentials..!", Toast.LENGTH_SHORT).show();
                }else if (txt_password.length() < 8){
                    Toast.makeText(AdminRegisterActivity.this, "Password too Short..!", Toast.LENGTH_SHORT).show();
                } else {
                    registerAdmin(txt_username, txt_password);
                }
            }
        });
    }

    private void registerAdmin(String username, String password) {
        auth.createUserWithEmailAndPassword(username, password).addOnCompleteListener(AdminRegisterActivity.this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    Toast.makeText(AdminRegisterActivity.this, "Registered Successfully..!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(AdminRegisterActivity.this, MainActivity.class));
                    finish();
                } else {
                    Toast.makeText(AdminRegisterActivity.this, "Registration Failed..!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}