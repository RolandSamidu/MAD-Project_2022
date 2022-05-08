package com.rsd_tecnology.adminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.android.material.textfield.TextInputEditText;

public class AddSpecialNoticeActivity extends AppCompatActivity {

    private TextInputEditText noticeIdEdt,noticeNameEdt,noticeDateEdt,noticeVenueEdt,noticeDescriptionEdt,noticeImageLink;
    private Button addNoticeBtn;
    private ProgressBar loadingPB;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_special_notice);
    }
}