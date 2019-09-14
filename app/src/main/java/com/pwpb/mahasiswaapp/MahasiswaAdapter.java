package com.pwpb.mahasiswaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.MahasiswaViewHolder> {

    Context context;
    OnUserClickListener listener;
    List<Mahasiswa> mahasiswaList;

    public interface OnUserClickListener{
        void onUserClick(Mahasiswa currentPerson, String action);
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view =  LayoutInflater.from(parent.getContext()).inflate(R.layout.format_data_mahasiswa_recycler,parent,false);
        MahasiswaViewHolder mahasiswaViewHolder = new MahasiswaViewHolder(view);
        return mahasiswaViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        final Mahasiswa mahasiswaData  = mahasiswaList.get(position);
        holder.txt_nama.setText(mahasiswaData.getNama());
    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder {

        TextView txt_nama;

        public MahasiswaViewHolder(@NonNull View itemView) {

            super(itemView);
            txt_nama = (TextView) itemView.findViewById(R.id.txt_nama);

        }
    }

}