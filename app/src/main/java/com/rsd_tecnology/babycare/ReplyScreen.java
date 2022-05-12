package com.example.helpcenterhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class ReplyScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply_screen);
        Button btn = findViewById(R.id.btnupdateC);
        TextView txt = findViewById(R.id.question);
        EditText edittext = findViewById(R.id.reply);
        DOAQuestion doa =new DOAQuestion();
        Question ques_update = (Question) getIntent().getSerializableExtra("EDIT");
        if(ques_update !=null)
        {
            btn.setText("UPDATE");
            txt.setText(ques_update.getQuestion());
            edittext.setText(ques_update.getReply());
        }
        else
        {
            btn.setText("SUBMIT");
        }
        btn.setOnClickListener(v->
        {
            HashMap<String,Object> hashMap =new HashMap<>();
            hashMap.put("reply",edittext.getText().toString());
            doa.update(ques_update.getKey(),hashMap).addOnSuccessListener(suc->
            {

                Intent i = new Intent(ReplyScreen.this,MainActivity.class);
                startActivity(i);
                Toast.makeText(this, "Saved your response!", Toast.LENGTH_SHORT).show();
            }).addOnFailureListener(er->
            {
                Toast.makeText(this, ""+er.getMessage(), Toast.LENGTH_SHORT).show();
            });


        });
    }
}