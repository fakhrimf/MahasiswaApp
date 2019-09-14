package com.pwpb.mahasiswaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class DataMahasiswa extends AppCompatActivity implements MahasiswaAdapter.OnUserClickListener {

    Button inputData;
    RecyclerView recyclerView;
    Context context;

    List<Mahasiswa> mahasiswaList;

    public DataMahasiswa() {

    }

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_mahasiswa);

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
                openDialogInputData();
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

    public void openDialogInputData() {
        DialogInputData exampleDialog = new DialogInputData();
        if (exampleDialog.getDialog() != null && exampleDialog.getDialog().getWindow() != null) {
            exampleDialog.getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            exampleDialog.getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        exampleDialog.show(getSupportFragmentManager(), "Dialog Ketentuan");
    }

    @Override
    public void onUserClick(Mahasiswa currentPerson, String action) {

    }
}
