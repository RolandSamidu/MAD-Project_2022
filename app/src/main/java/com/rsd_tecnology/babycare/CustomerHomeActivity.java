package com.rsd_tecnology.babycare;

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

public class CustomerHomeActivity extends AppCompatActivity {
    private Button report;
    private Button blog;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Baby Care");
        actionBar.setSubtitle("Home");

        report = findViewById(R.id.report);
        blog = findViewById(R.id.Blog);
        logout = findViewById(R.id.logout);

        report.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomerHomeActivity.this , CHDRActivity.class));
                finish();
            }
        });

        blog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CustomerHomeActivity.this , BlogActivity.class));
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                Toast.makeText(CustomerHomeActivity.this, "Logout!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(CustomerHomeActivity.this, MainActivity.class));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer_home, menu);
        return super.onCreateOptionsMenu(menu);
    }

}