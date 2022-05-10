package com.rsd_tecnology.adminapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.nio.Buffer;

public class AdminHomeActivity extends AppCompatActivity {
    private Button report;
    private Button sp;
    private Button blog;
    private Button hc;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Admin Panel");
        actionBar.setSubtitle("Home");

        report = findViewById(R.id.report);
        sp = findViewById(R.id.sp);
        blog = findViewById(R.id.blog);
        hc = findViewById(R.id.hc);
        logout = findViewById(R.id.logout);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AdminHomeActivity.this, CHDRActivity.class));
                finish();
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(AdminHomeActivity.this, "Logout!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(AdminHomeActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

}