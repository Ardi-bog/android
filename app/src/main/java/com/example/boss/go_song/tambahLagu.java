package com.example.boss.go_song;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nguyenhoanglam.imagepicker.model.Config;
import com.nguyenhoanglam.imagepicker.model.Image;
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class tambahLagu extends AppCompatActivity {

    @BindView(R.id.judul)
    EditText judul;
    @BindView(R.id.artis)
    EditText artis;
    @BindView(R.id.genre)
    EditText genre;
    @BindView(R.id.poster)
    ImageView poster;
    @BindView(R.id.simpan)
    Button simpan;

    private ModelLagu modelLagu;
    private ArrayList<Image> imageLibrary = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_lagu);
        ButterKnife.bind(this);
     }
    @OnClick(R.id.poster)
    public void onViewClickedImage() {
        ImagePicker.with(this)
                .setFolderMode(true)
                .setMaxSize(10)
                .setMultipleMode(false)
                .setCameraOnly(false)
                .setFolderTitle("Albums")
                .setSelectedImages(imageLibrary)
                .setAlwaysShowDoneButton(true)
                .setKeepScreenOn(true)
                .start();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data!=null){
            imageLibrary = data.getParcelableArrayListExtra(Config.EXTRA_IMAGES);
            Glide.with(this)
                    .load(imageLibrary.get(0).getPath()).into(poster);
        } }

}
