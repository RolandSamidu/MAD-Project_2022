package com.rsd_tecnology.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CHDRActivity extends AppCompatActivity {
    private Button immunization;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chdractivity);

        immunization = findViewById(R.id.immunization);

        immunization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CHDRActivity.this, ImmunizationActivity.class));
                finish();
            }
        });
    }
}