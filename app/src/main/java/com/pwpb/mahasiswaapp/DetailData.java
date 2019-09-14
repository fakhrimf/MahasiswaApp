package com.pwpb.mahasiswaapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailData extends AppCompatActivity {

    TextView nomor,nama,alamat,tgl_lahir,jenkel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_data);
        nomor = findViewById(R.id.tvNomor);
        nama = findViewById(R.id.tvNama);
        alamat = findViewById(R.id.tvAlamat);
        tgl_lahir = findViewById(R.id.tvTgl);
        jenkel = findViewById(R.id.tvJenkel);
        ActionBar a = getSupportActionBar();
        assert a != null;
        a.setDisplayHomeAsUpEnabled(true);
        Intent i = getIntent();
        String namaa = i.getStringExtra("nama");
        String alamatt = i.getStringExtra("alamat");
        String jenkell = i.getStringExtra("jenkel");
        String nomorr = i.getStringExtra("nomor");
        String tgl_lahirr = i.getStringExtra("tgl_lahir");
        nomor.setText("  Nomor : "+nomorr);
        nama.setText("  Nama : "+namaa);
        alamat.setText("  Alamat : "+alamatt);
        tgl_lahir.setText("  Tanggal Lahir : "+tgl_lahirr);
        jenkel.setText("  Jenis Kelamin : "+jenkell);
        a.setTitle("Detail "+namaa);
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp(){
        super.onBackPressed();
        return true;
    }
}
