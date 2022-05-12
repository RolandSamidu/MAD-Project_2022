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


import java.util.HashMap;
import java.util.Map;

public class EditBlogsActivity extends AppCompatActivity {

    private TextInputEditText blogIdEdt,blogDateEdt,blogTopicEdt,blogImageEdt,blogCategoryEdt,blogDescriptionEdt;
    private Button updateBlogBtn, deleteBlogBtn;
    private ProgressBar loadingPB;

    private String blogID;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_blogs);
        blogIdEdt = findViewById(R.id.idEditId);
        blogDateEdt = findViewById(R.id.idEditDate);
        blogTopicEdt = findViewById(R.id.idEditTopic);
        blogImageEdt = findViewById(R.id.idEditImage);
        blogCategoryEdt = findViewById(R.id.idEditCategory);
        blogDescriptionEdt = findViewById(R.id.idEditDescription);
        updateBlogBtn = findViewById(R.id.idBtnUpdateBlog);
        deleteBlogBtn = findViewById(R.id.idBtnDeleteBlog);
        loadingPB = findViewById(R.id.idPBLoading);


        updateBlogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loadingPB.setVisibility(View.VISIBLE);
                String blogId = blogIdEdt.getText().toString();
                String blogDate = blogDateEdt.getText().toString();
                String blogTopic = blogTopicEdt.getText().toString();
                String blogImage = blogImageEdt.getText().toString();
                String blogCategory = blogCategoryEdt.getText().toString();
                String blogDescription = blogDescriptionEdt.getText().toString();

                Map<String, Object> map = new HashMap<>();
                map.put("blogId",blogId);
                map.put("blogDate",blogDate);
                map.put("blogTopic",blogTopic);
                map.put("blogImage",blogImage);
                map.put("blogCategory",blogCategory);
                map.put("blogDescription",blogDescription);
                map.put("blogID",blogID);



            }
        });

        deleteBlogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteBlog();
            }
        });

    }
    private void deleteBlog(){

        Toast.makeText(this, "Blog Deleted...", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(EditBlogsActivity.this,MainActivity.class));

    }
}