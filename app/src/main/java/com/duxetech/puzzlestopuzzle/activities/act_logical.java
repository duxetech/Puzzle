package com.duxetech.puzzlestopuzzle.activities;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.duxetech.puzzlestopuzzle.R;

import com.duxetech.puzzlestopuzzle.adapters.ad_rv_horizontal;
import com.duxetech.puzzlestopuzzle.adapters.ad_rv_vertical;
import com.duxetech.puzzlestopuzzle.data.Quiz;
import com.duxetech.puzzlestopuzzle.data.xml_parser;

import java.util.ArrayList;
import java.util.List;

public class act_logical extends AppCompatActivity {
    int id = -1, position=-1;
    xml_parser x;
    List<Quiz> quiz;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getIntent().getIntExtra("id",-1);
        setContentView(R.layout.act_answer);

        rv = findViewById(R.id.rv_horizontal);
        x = new xml_parser();
        quiz = new ArrayList<>();
        quiz = x.getLogicalQuiz(this);
        setTitle(id+1+"/"+quiz.size()+"       "+"Logical Puzzles");

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        final LinearLayoutManager lm = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);

        rv.setLayoutManager(lm);
        ad_rv_horizontal adapter = new ad_rv_horizontal(this,quiz);
        snapHelper.attachToRecyclerView(rv);
        rv.setAdapter(adapter);
        rv.scrollToPosition(id);

        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState==rv.SCROLL_STATE_IDLE){
                    position = lm.findFirstVisibleItemPosition();
                    setTitle(position+1+"/"+quiz.size()+"     "+"Logical");
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(act_logical.this,MainActivity.class);
        startActivity(i);
    }
}
