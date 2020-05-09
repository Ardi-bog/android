package com.example.boss.go_song;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database
(entities = {ModelLagu.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public abstract LaguDao userDao();
}
