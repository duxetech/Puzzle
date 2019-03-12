package com.duxetech.puzzlestopuzzle.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.View;
import android.widget.TextView;

import com.duxetech.puzzlestopuzzle.R;
import com.duxetech.puzzlestopuzzle.adapters.ad_rv_horizontal;
import com.duxetech.puzzlestopuzzle.data.Quiz;
import com.duxetech.puzzlestopuzzle.data.xml_parser;

import java.util.ArrayList;
import java.util.List;

public class act_teaser extends AppCompatActivity {
    int id = -1;
    xml_parser x;
    List<Quiz> quiz;
    RecyclerView rv;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_answer);
        id = getIntent().getIntExtra("id",-1);

        rv = findViewById(R.id.rv_horizontal);
        x = new xml_parser();
        quiz = new ArrayList<>();
        quiz = x.getTeaserQuiz(this);
        final int total = quiz.size();

        setTitle(" "+(id+1)+"/"+total+"       "+"Brain Teasers");

        final LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        rv.setLayoutManager(lm);
        ad_rv_horizontal adapter = new ad_rv_horizontal(this,quiz);
        rv.setAdapter(adapter);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(rv);
        rv.scrollToPosition(id);

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==rv.SCROLL_STATE_IDLE){
                    position = lm.findFirstVisibleItemPosition();
                    setTitle(" "+(position+1)+"/"+total+"       "+"Brain Teasers");
                }
            }
        });

    }

}
