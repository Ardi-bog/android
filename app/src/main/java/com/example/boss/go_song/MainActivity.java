package com.example.boss.go_song;

import android.os.BaseBundle;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.boss.go_song.API.BaseApp;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fargment);
        getFragmentPage(new home());

        BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
        bottomNavigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;

                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new home();
                        getFragmentPage(fragment);
                        return true;
                    case R.id.playlist:
                        fragment = new playlist();
                        getFragmentPage(fragment);
                        return true;
                    case R.id.profile:
                        fragment = new profile();
                        getFragmentPage(fragment);
                        return true;

                }
                return getFragmentPage(fragment);
            }
        });

        }

    private boolean getFragmentPage(Fragment fragment){
        if(fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, fragment)
                    .commit();
            return false;
        }
        return false;
    }
}
