package com.rsd_tecnology.babycare;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class CHDRActivity extends AppCompatActivity {
    private Button immunization, healthRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chdractivity);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Baby Care");
        actionBar.setSubtitle("CHDR");

        immunization = findViewById(R.id.immunization);
        healthRecord = findViewById(R.id.healthRecord);


        immunization.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CHDRActivity.this, ImmunizationActivity.class));
                finish();
            }
        });

        healthRecord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CHDRActivity.this, HealthReportActivity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
}