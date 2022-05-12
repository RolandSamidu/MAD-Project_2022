package com.rsd_tecnology.babycare;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class AddHealthReportActivity extends AppCompatActivity {

    EditText date,topic,description;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_health_report);

        date = (EditText) findViewById(R.id.txtDate1);
        topic = (EditText) findViewById(R.id.txtTopic);
        description = (EditText) findViewById(R.id.txtDescription);

        btnAdd = (Button) findViewById(R.id.btnAdd1);
        btnBack = (Button) findViewById(R.id.back1);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertData();
                clearAll();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AddHealthReportActivity.this, HealthReportActivity.class));
                finish();
            }
        });

    }

    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("date",date.getText().toString());
        map.put("topic",topic.getText().toString());
        map.put("description",description.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("healthRecords").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddHealthReportActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddHealthReportActivity.this, "Error While Inserting", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll()
    {
        date.setText("");
        topic.setText("");
        description.setText("");
    }
}