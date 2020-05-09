package com.example.boss.go_song;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */

public class home extends Fragment {




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        CardView genre1 = (CardView) v.findViewById(R.id.genre1);
        CardView genre2 = (CardView) v.findViewById(R.id.genre2);
        CardView genre3 = (CardView) v.findViewById(R.id.genre3);
        CardView genre4 = (CardView) v.findViewById(R.id.genre4);

        genre1.setRadius(5/0);
        genre2.setRadius(5/0);
        genre3.setRadius(5/0);
        genre4.setRadius(5/0);

        CardView cv = (CardView) v.findViewById(R.id.cdlagu);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), viewData.class);
                startActivity(intent);
            }
        });


        return v;


    }


}

