package com.pwpb.mahasiswaapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class konekdb extends SQLiteOpenHelper {
    private static final int DB_VERSION=1;
    private static final String DB_NAME="Mahasiswa";
    private static final String TABLE_NAME="tbl_mahasiswa";
    private static final String KEY_ID="id";

    public konekdb(Context c){
        super(c,DB_NAME,null,DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createUserTable = "CREATE TABLE "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, nama TEXT, tgl_lahir TEXT, jenkel TEXT, alamat TEXT)";
        db.execSQL(createUserTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVer, int newVer){
        String sql = ("DROP TABLE IF EXISTS "+TABLE_NAME);
        db.execSQL(sql);
        onCreate(db);
    }

    public void insert(Mahasiswa m){
        SQLiteDatabase db =getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(KEY_ID,m.getNomor());
        values.put("nama",m.getNama());
        values.put("tgl_lahir",m.getTgl_lahir());
        values.put("jenkel",m.getJenkel());
        values.put("alamat",m.getAlamat());
        db.insert(TABLE_NAME,null,values);
    }

    public List<Mahasiswa> selectUserData(){
        ArrayList<Mahasiswa> list= new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        String[] columns={KEY_ID,"nama","tgl_lahir","jenkel","alamat"};
        Cursor c =db.query(TABLE_NAME,columns,null,null,null,null,null);
        while (c.moveToNext()){
            String id =c.getString(0);
            String nama =c.getString(1);
            String tgl =c.getString(2);
            String jenkel =c.getString(3);
            String alamat =c.getString(4);
            Mahasiswa m = new Mahasiswa();
            m.setId(id);
            m.setNama(nama);
            m.setTgl_lahir(tgl);
            m.setJenkel(jenkel);
            m.setAlamat(alamat);
            list.add(m);
        }
        return list;
    }

    public void delete(String id){
        SQLiteDatabase db =getWritableDatabase();
        String whereClause=KEY_ID+"='"+id+"'";
        db.delete(TABLE_NAME,whereClause,null);
    }
    public void update(Mahasiswa mahasiswa){
        SQLiteDatabase db=getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("nama",mahasiswa.getNama());
        values.put("tgl_lahir",mahasiswa.getTgl_lahir());
        values.put("jenkel",mahasiswa.getJenkel());
        values.put("alamat",mahasiswa.getAlamat());
        String whereClause=KEY_ID+"='"+mahasiswa.getId()+"'";
        db.update(TABLE_NAME,values,whereClause,null);
    }
}