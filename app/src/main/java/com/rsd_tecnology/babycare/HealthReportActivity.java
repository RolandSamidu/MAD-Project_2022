package com.rsd_tecnology.babycare;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class HealthReportActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    HealthReportAdapter healthReportAdapter;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_report);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Health Record");

        recyclerView = (RecyclerView)findViewById(R.id.rv2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<HealthReportModel> options =
                new FirebaseRecyclerOptions.Builder<HealthReportModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("healthRecords"), HealthReportModel.class)
                        .build();

        healthReportAdapter = new HealthReportAdapter(options);
        recyclerView.setAdapter(healthReportAdapter);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.floatingActionButton2);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AddHealthReportActivity.class));
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        healthReportAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        healthReportAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.customer_home, menu);
        return super.onCreateOptionsMenu(menu);
    }
}