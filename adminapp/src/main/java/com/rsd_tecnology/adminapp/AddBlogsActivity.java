package com.rsd_tecnology.adminapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;


public class AddBlogsActivity extends AppCompatActivity  {


    private TextInputEditText blogIdEdt,blogDateEdt,blogTopicEdt,blogImageEdt,blogCategoryEdt,blogDescriptionEdt;
    private Button addBlogBtn;
    private ProgressBar loadingPB;
    private String blogID;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blogs);
        blogIdEdt = findViewById(R.id.idEditId);
        blogDateEdt = findViewById(R.id.idEditDate);
        blogTopicEdt = findViewById(R.id.idEditTopic);
        blogImageEdt = findViewById(R.id.idEditImage);
        blogCategoryEdt = findViewById(R.id.idEditCategory);
        blogDescriptionEdt = findViewById(R.id.idEditDescription);
        addBlogBtn = findViewById(R.id.idBtnAddBlog);
        loadingPB = findViewById(R.id.idPBLoading);

        addBlogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadingPB.setVisibility(View.VISIBLE);
                String blogId = blogIdEdt.getText().toString();
                String blogDate = blogDateEdt.getText().toString();
                String blogTopic = blogTopicEdt.getText().toString();
                String blogImage = blogImageEdt.getText().toString();
                String blogCategory = blogCategoryEdt.getText().toString();
                String blogDescription = blogDescriptionEdt.getText().toString();
                blogID = blogId;




            }
        });


    }

}