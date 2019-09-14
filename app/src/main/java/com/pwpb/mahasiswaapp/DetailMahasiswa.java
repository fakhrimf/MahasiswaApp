package com.pwpb.mahasiswaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailMahasiswa extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_mahasiswa);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Detail Mahasiswa");

    }
}
