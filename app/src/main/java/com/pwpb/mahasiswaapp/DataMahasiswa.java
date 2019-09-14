package com.pwpb.mahasiswaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class DataMahasiswa extends AppCompatActivity implements MahasiswaAdapter.OnUserClickListener {

    Button inputData;
    RecyclerView recyclerView;
    Context context;
    Button btnLihat;
    Context con;

    List<Mahasiswa> mahasiswaList;

    public DataMahasiswa() {

    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);
        btnLihat = findViewById(R.id.btnLihat);
        con = getApplicationContext();

        getSupportActionBar().setTitle("Data Mahasiswa");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);
        setupRecyclerView();
        inputData = findViewById(R.id.input_data);
        inputData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), InputData.class);
                startActivity(i);
            }
        });
    }

    private void setupRecyclerView() {
        konekdb db = new konekdb(this);

        recyclerView = findViewById(R.id.recycler_view);

        mahasiswaList = new ArrayList<>();
        mahasiswaList = db.selectUserData();
        MahasiswaAdapter adapter = new MahasiswaAdapter(context, mahasiswaList, this );
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void openDialogInputData(String alamat, String tgl_lahir, String jenkel, String nomor, String nama,String id) {
        DialogInputData exampleDialog = new DialogInputData();
        Bundle args = new Bundle();
        args.putString("alamat",alamat);
        args.putString("tgl_lahir",tgl_lahir);
        args.putString("jenkel",jenkel);
        args.putString("nomor",nomor);
        args.putString("nama",nama);
        args.putString("id",id);
        if (exampleDialog.getDialog() != null && exampleDialog.getDialog().getWindow() != null) {
            exampleDialog.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            exampleDialog.getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        exampleDialog.setArguments(args);
        exampleDialog.show(getSupportFragmentManager(), "Dialog Ketentuan");
    }

    @Override
    public void onUserClick(String alamat, String tgl_lahir, String jenkel, String nomor, String nama, String id) {
        openDialogInputData(alamat,tgl_lahir,jenkel,nomor,nama,id);
    }
}
