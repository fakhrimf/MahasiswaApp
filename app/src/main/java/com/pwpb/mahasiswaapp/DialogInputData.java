package com.pwpb.mahasiswaapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogInputData extends DialogFragment implements View.OnClickListener
{

    Button lihat_data, update_data, hapus_data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.format_dialog_input_data, container, false);
        // Set transparent background and no title
        if (getDialog() != null && getDialog().getWindow() != null) {
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        }
        return view;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.format_dialog_input_data, null);
        builder.setView(view);


        lihat_data = view.findViewById(R.id.btnLihatData);
        lihat_data.setOnClickListener(this);
        update_data = view.findViewById(R.id.btnUpdateData);
        update_data.setOnClickListener(this);
        hapus_data = view.findViewById(R.id.btnHapusData);

        return builder.create();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.btnLihatData:
                startActivity(new Intent(getContext(), DetailMahasiswa.class));
                break;
            case R.id.btnUpdateData:
                startActivity(new Intent(getContext(), InputData.class));
                break;
            case R.id.btnHapusData:
                break;
        }
    }
}
