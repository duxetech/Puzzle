package com.duxetech.puzzlestopuzzle.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duxetech.puzzlestopuzzle.R;
import com.duxetech.puzzlestopuzzle.activities.act_teaser;
import com.duxetech.puzzlestopuzzle.adapters.ad_rv_vertical;
import com.duxetech.puzzlestopuzzle.data.Quiz;
import com.duxetech.puzzlestopuzzle.data.xml_parser;

import java.util.List;

/**
 * Created by Karthik Swamy on 10-12-2018.
 */
public class frag_teasers extends Fragment {
    TextView tv;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_linear_items,container,false);
        xml_parser t = new xml_parser();
        List<Quiz> list ;
        list = t.getTeaserQuiz(getActivity());
        tv = view.findViewById(R.id.tv_frag_title);
        tv.setText("Brain teasers");
        RecyclerView rv ;
        rv = view.findViewById(R.id.rv_linear);

        rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        ad_rv_vertical adapter = new ad_rv_vertical(this.getActivity(),t.getTitle(list),act_teaser.class);
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
