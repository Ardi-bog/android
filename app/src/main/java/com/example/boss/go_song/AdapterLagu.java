package com.example.boss.go_song;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterLagu extends RecyclerView.Adapter<AdapterLagu.ViewHolder>{

    private Context mContext;
    public static final String EXTRA_LAGU = "EXTRA_MEMBER";
    public List<ModelLagu> arrayList = new ArrayList<>();

    public AdapterLagu (Context mContext, List<ModelLagu> albumList){
        this.mContext = mContext;
        this.arrayList = albumList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.tampil_lagu, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        final ModelLagu lagu = arrayList.get(position);
        holder.judul.setText(lagu.judul);
        holder.artis.setText(lagu.artis);
    //untuk menampilkan gambar menggunakan glide
        Glide.with(holder.itemView.getContext())
                .load(lagu.poster)
                .into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), tambahLagu.class);
                intent.putExtra(EXTRA_LAGU, arrayList.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.judul)
        TextView judul;
        @BindView(R.id.img)
        ImageView img;
        @BindView(R.id.artis)
        TextView artis;
        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
