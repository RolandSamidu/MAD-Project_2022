package com.example.helpcenterhome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AskQuestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);
        int id=1;
        Button btn =  findViewById(R.id.savebtn);
        final EditText editText = findViewById(R.id.quetiontxt);

        DOAQuestion doa = new DOAQuestion();

        btn.setOnClickListener(v->{
            if(editText.getText().length()<20){
                Toast.makeText(this,"Question must have more than 20 characters",Toast.LENGTH_SHORT);
            }else {
                Question ques = new Question(editText.getText().toString(), "", id);
                doa.add(ques).addOnSuccessListener(suc -> {
                    editText.setText("");
                    Toast.makeText(this, "Send Question!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(AskQuestion.this, MainActivity.class);
                    startActivity(i);
                }).addOnFailureListener(er -> {
                    Toast.makeText(this, "" + er.getMessage(), Toast.LENGTH_SHORT).show();
                    System.out.println(er.getMessage());
                });
            }
        });
    }
}