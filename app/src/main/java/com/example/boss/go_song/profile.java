package com.example.boss.go_song;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class profile extends Fragment {
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    List<ModelLagu> lisSiswaModel = new ArrayList<>();

    public profile() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_profile, container, false);

        ButterKnife.bind(getActivity());
        lisSiswaModel = myApp.db.userDao().getAll();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        AdapterLagu adapter = new AdapterLagu(getActivity(), lisSiswaModel);
        recyclerView.setAdapter(adapter);

        return v;
    }
    @OnClick(R.id.fab)
    public void onViewClicked() {
        startActivity(new Intent(getActivity(),tambahLagu.class));
    }

}
