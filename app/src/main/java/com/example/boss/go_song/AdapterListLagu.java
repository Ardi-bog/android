package com.example.boss.go_song;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterListLagu extends RecyclerView.Adapter<AdapterListLagu.ViewHolder>{

    private ArrayList<ModelLagu> lagu;
    Context context;

    public AdapterListLagu(Context context, ArrayList<ModelLagu> lagu) {
        this.lagu = lagu;
        this.context = context;
    }
    @Override
    public AdapterListLagu.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tampil_lagu, null);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.judul.setText(String.valueOf(lagu.get(position).getJudul()));
        holder.artis.setText(String.valueOf(lagu.get(position).getArtis()));
    }

    @Override
    public int getItemCount() {
        return lagu.size();
    }

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView judul, artis;

    public ViewHolder(View itemView) {
        super(itemView);
        judul = (TextView)itemView.findViewById(R.id.judul);
        artis = (TextView)itemView.findViewById(R.id.artis);
    }
}
}
