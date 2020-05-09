package com.example.boss.go_song;

import android.app.Application;
import android.arch.persistence.room.Room;

public class myApp extends Application {
    public static AppDatabase db;
    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"gosong.db").allowMainThreadQueries().build();
    }
}
