package com.example.helpcenterhome;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HelpCenter extends AppCompatActivity {
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    DOAQuestion doa;
    MenuAdapter adapter;
    String key = null;
    boolean isLoading = false;
    public int admin=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_center);

        Button btn = (Button) findViewById(R.id.askQ);

//visibility of ask question(admin and user)
        if(admin==0)
        {
            btn.setVisibility(View.VISIBLE);
        }
        else{
            btn.setVisibility(View.INVISIBLE);
        }



        //connect to frontend(xml)
        swipeRefreshLayout = findViewById(R.id.swip);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter= new MenuAdapter(this);
        recyclerView.setAdapter(adapter);
        doa = new DOAQuestion();
        loadData();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItem = linearLayoutManager.getItemCount();
                int lastVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if(totalItem < lastVisible+3)
                {
                    if(!isLoading)
                    {
                        isLoading=true;
                        loadData();
                    }
                }
            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpCenter.this,AskQuestion.class);
                startActivity(intent);
            }
        });
    }

    private void loadData()
    {

        swipeRefreshLayout.setRefreshing(true);
        if(admin==1) {
            doa.get(key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ArrayList<Question> qarray = new ArrayList<>();
                    for (DataSnapshot data : snapshot.getChildren()) {
                        Question qus = data.getValue(Question.class);
                        qus.setKey(data.getKey());
                        qarray.add(qus);
                        key = data.getKey();

                    }

                    adapter.setItems(qarray);
                    adapter.notifyDataSetChanged();
                    isLoading = false;
                    swipeRefreshLayout.setRefreshing(false);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }else{
            doa.getbyid(key).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    ArrayList<Question> qarray = new ArrayList<>();
                    for (DataSnapshot data : snapshot.getChildren())
                    {
                        Question qus = data.getValue(Question.class);
                        qus.setKey(data.getKey());
                        qarray.add(qus);
                        key = data.getKey();

                    }

                    adapter.setItems(qarray);
                    adapter.notifyDataSetChanged();
                    isLoading =false;
                    swipeRefreshLayout.setRefreshing(false);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    swipeRefreshLayout.setRefreshing(false);
                }
            });
        }
    }
}