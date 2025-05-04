package com.tugas.platform.modulempat;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<ModelMahasiswa>{
    private List<ModelMahasiswa> listMahasiswa;
    private Context mContext;
    private int layout;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<ModelMahasiswa> objects) {
        super(context, resource, objects);
        this.mContext = context;
        this.listMahasiswa = objects;
        this.layout = resource;
    }
    static class MahasiswaHolder{
        ImageView fotoMhs;
        TextView namaMhs;
        TextView nimMhs;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View v = convertView;
        MahasiswaHolder holder;

        if(v == null){
            LayoutInflater li = ((Activity)mContext).getLayoutInflater();
            v = li.inflate(layout, parent, false);

            holder = new MahasiswaHolder();
            holder.fotoMhs = v.findViewById(R.id.imageView);
            holder.namaMhs = v.findViewById(R.id.tvNama);
            holder.nimMhs = v.findViewById(R.id.tvNim);

            v.setTag(holder);
        } else {
            holder = (MahasiswaHolder) v.getTag();
        }

        ModelMahasiswa mahasiswa = listMahasiswa.get(position);
        holder.fotoMhs.setImageResource(mahasiswa.getmImg());
        holder.namaMhs.setText(mahasiswa.getNama());
        holder.nimMhs.setText(mahasiswa.getNim());

        return v;
    }


}
