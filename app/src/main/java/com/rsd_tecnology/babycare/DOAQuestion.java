package com.example.helpcenterhome;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.HashMap;

public class DOAQuestion
{
    private DatabaseReference databaseReference;
    public DOAQuestion()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(Question.class.getSimpleName());
    }


    //ADD FUNCTION
    public Task<Void> add(Question qus)
    {
        return databaseReference.push().setValue(qus);
    }



    //UPDATE FUNCTION
    public Task<Void> update(String key, HashMap<String,Object> hashMap)
    {
        return databaseReference.child(key).updateChildren(hashMap);
    }


    //DELETE FUNCTION
    public Task<Void> remove(String key)
    {
        return databaseReference.child(key).removeValue();
    }


    //VIEW FUNCTION
    public Query get(String key)
    {
        if(key == null)
        {
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }
    public Query getbyid(String key)
    {
        if(key == null)
        {
            return databaseReference.orderByChild("id").equalTo(1).limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }

    public Query get()
    {
        return databaseReference;
    }
}
