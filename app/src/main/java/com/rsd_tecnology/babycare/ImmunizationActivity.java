package com.rsd_tecnology.babycare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class ImmunizationActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImmunizationAdapter immunizationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_immunization);

        recyclerView = (RecyclerView)findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<ImmunizationModel> options =
                new FirebaseRecyclerOptions.Builder<ImmunizationModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("immunizations"), ImmunizationModel.class)
                        .build();

        immunizationAdapter = new ImmunizationAdapter(options);
        recyclerView.setAdapter(immunizationAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        immunizationAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        immunizationAdapter.stopListening();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.search, menu);
        MenuItem item = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                txtSearch(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String nextText) {
                txtSearch(nextText);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    private void txtSearch(String str){

        FirebaseRecyclerOptions<ImmunizationModel> options =
                new FirebaseRecyclerOptions.Builder<ImmunizationModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("immunizations").orderByChild("date").startAt(str).endAt(str+"~"), ImmunizationModel.class)
                        .build();

        immunizationAdapter = new ImmunizationAdapter(options);
        immunizationAdapter.startListening();
        recyclerView.setAdapter(immunizationAdapter);

    }
}