package com.pwpb.mahasiswaapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Update extends AppCompatActivity {
    private SimpleDateFormat df;
    private DatePickerDialog dp;
    private EditText nomor, nama, alamat;
    private Spinner jenkel;
    private Button save, datePick;

    private void initUI() {
        ActionBar a = getSupportActionBar();
        assert a != null;
        a.setTitle("Update Data");
        a.setDisplayHomeAsUpEnabled(true);
        nomor = findViewById(R.id.NomorD);
        nomor.setEnabled(false);
        nomor.setInputType(InputType.TYPE_NULL);
        nama = findViewById(R.id.NamaD);
        alamat = findViewById(R.id.AlamatD);
        save = findViewById(R.id.btnUpdate);
        datePick = findViewById(R.id.btnDateD);
        jenkel = findViewById(R.id.spinnerJenkelD);
        Intent i = getIntent();
        String namaa = i.getStringExtra("nama");
        String alamatt = i.getStringExtra("alamat");
        String jenkell = i.getStringExtra("jenkel");
        String nomorr = i.getStringExtra("nomor");
        String tgl_lahirr = i.getStringExtra("tgl_lahir");
        if (jenkell.equalsIgnoreCase("Laki-laki")) jenkell = "0";
        else jenkell = "1";
        nomor.setText(nomorr);
        nama.setText(namaa);
        alamat.setText(alamatt);
        datePick.setText(tgl_lahirr);
        jenkel.setSelection(Integer.parseInt(jenkell));
    }

    @Override
    public boolean onSupportNavigateUp(){
        super.onBackPressed();
        return true;
    }

    public void initBtn() {
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                konekdb k = new konekdb(getApplicationContext());
                Mahasiswa m = new Mahasiswa();
                String nomorr = nomor.getText().toString();
                String namaa = nama.getText().toString();
                String alamatt = alamat.getText().toString();
                String tanggal = datePick.getText().toString();
                String jenkell = jenkel.getSelectedItem().toString();
                if (nomorr.isEmpty() || namaa.isEmpty() || alamatt.isEmpty() || tanggal.isEmpty() || jenkell.isEmpty()){
                    Toast.makeText(getApplicationContext(),"Isi semua data terlebih dahulu", Toast.LENGTH_SHORT).show();
                } else {
                    m.setNomor(nomorr);
                    m.setNama(namaa);
                    m.setAlamat(alamatt);
                    m.setTgl_lahir(tanggal);
                    m.setJenkel(jenkell);
                    k.update(m);
                    Update.super.onBackPressed();
                    Toast.makeText(getApplicationContext(),"Data "+namaa+" Diubah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        initUI();
        initBtn();
        df = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        datePick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
    }

    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        dp = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                datePick.setText(df.format(newDate.getTime()));
            }

        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        dp.show();
    }
}
