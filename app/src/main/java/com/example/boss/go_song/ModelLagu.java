package com.example.boss.go_song;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.os.Parcel;
import android.os.Parcelable;

@Entity
public class ModelLagu  implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "judul")
    String judul;
    @ColumnInfo(name = "artis")
    String artis;
    @ColumnInfo(name = "genre")
    String genre;
    @ColumnInfo(name = "lagu")
    String lagu;
    @ColumnInfo(name = "poster")
    String poster;
    @ColumnInfo(name = "id_pengupload")
    private int id_pengupload;

    public ModelLagu() {
    }
    protected ModelLagu(Parcel in) {
        id = in.readInt();
        judul = in.readString();
        artis = in.readString();
        genre = in.readString();
        lagu = in.readString();
        poster = in.readString();
        id_pengupload = in.readInt();
    }
    public static final Creator<ModelLagu> CREATOR = new Creator<ModelLagu>() {
        @Override
        public ModelLagu createFromParcel(Parcel in) {
            return new ModelLagu(in);
        }
        @Override
        public ModelLagu[] newArray(int size) {
            return new ModelLagu[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getArtis() {
        return artis;
    }

    public void setArtis(String artis) {
        this.artis = artis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLagu() {
        return lagu;
    }

    public void setLagu(String lagu) {
        this.lagu = lagu;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public int getId_pengupload() {
        return id_pengupload;
    }

    public void setId_pengupload(int id_pengupload) {
        this.id_pengupload = id_pengupload;
    }
    @Override
    public int describeContents() {
        return 0; }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(id);
        parcel.writeString(judul);
        parcel.writeString(artis);
        parcel.writeString(poster);
        parcel.writeString(genre);
        parcel.writeString(lagu);
        parcel.writeInt(id_pengupload);
    }
}
