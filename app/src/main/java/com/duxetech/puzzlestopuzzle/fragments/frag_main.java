package com.duxetech.puzzlestopuzzle.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duxetech.puzzlestopuzzle.R;

/**
 * Created by Karthik Swamy on 10-12-2018.
 */
public class frag_main extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_main,container,false);
       TextView tv_log = view.findViewById(R.id.tv_log);
       TextView tv_bt = view.findViewById(R.id.tv_bt);

       tv_log.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               loadFrag(new frag_logical());
           }
       });
       tv_bt.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               loadFrag(new frag_teasers());
           }
       });

        return view;
    }

    void loadFrag(Fragment f){
        getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frame_main_frag,f).commit();
    }

}
