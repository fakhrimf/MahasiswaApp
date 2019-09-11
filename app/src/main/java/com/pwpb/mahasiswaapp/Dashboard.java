package com.pwpb.mahasiswaapp;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {

    Button lihat,input,info;

    private void initUI(){
        ActionBar a = getSupportActionBar();
        assert a != null;
        a.setTitle("Dashboard");
        lihat = findViewById(R.id.btnLihat);
        input = findViewById(R.id.btnInput);
        info = findViewById(R.id.btnInfo);
    }

    private void initBtn(){
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), InputData.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        initUI();
        initBtn();
    }
}
