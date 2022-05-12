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

public class AddImmunizationActivity extends AppCompatActivity {

    EditText immunization, place, date;
    Button btnAdd, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_immunization);

        immunization = (EditText)findViewById(R.id.txtImmunization);
        place = (EditText)findViewById(R.id.txtPlace);
        date = (EditText)findViewById(R.id.txtDate);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnBack = (Button) findViewById(R.id.back);

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
                startActivity(new Intent(AddImmunizationActivity.this, ImmunizationActivity.class));
                finish();
            }
        });
    }

    private void insertData()
    {
        Map<String,Object> map = new HashMap<>();
        map.put("immunization",immunization.getText().toString());
        map.put("place",place.getText().toString());
        map.put("date",date.getText().toString());

        FirebaseDatabase.getInstance().getReference().child("immunizations").push()
                .setValue(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        Toast.makeText(AddImmunizationActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(AddImmunizationActivity.this, "Error While Inserting", Toast.LENGTH_SHORT).show();
                    }
                });
    }

    private void clearAll()
    {
        immunization.setText("");
        place.setText("");
        date.setText("");
    }

}