package com.duxetech.puzzlestopuzzle.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duxetech.puzzlestopuzzle.R;
import com.duxetech.puzzlestopuzzle.data.Quiz;

import java.util.List;

/**
 * Created by Karthik Swamy on 10-12-2018.
 */
public class ad_rv_horizontal extends RecyclerView.Adapter<ad_rv_horizontal.ViewHolder> {
    Context context;
    Class cl;
    List<Quiz> list;
    Quiz q;
    boolean show;

    public ad_rv_horizontal(Context context, List<Quiz> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_rv_hori,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
        public void onBindViewHolder(@NonNull final ViewHolder holder, final int i) {
        show = true;

        holder.tv_log_quest.setText(list.get(i).getQuestion());
        holder.tv_log_ans_toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tv_log_answer.setText(list.get(i).getAnswer());
                if(show){
                    holder.tv_log_ans_toggle.setText("Hide Answer");
                    show = false;
                } else {
                    holder.tv_log_ans_toggle.setText("Show Answer");
                    holder.tv_log_answer.setText(null);
                    show = true;
                }

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_log_quest,tv_log_answer,tv_log_ans_toggle;
        LinearLayout layout_rv_hori;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_log_quest = itemView.findViewById(R.id.tv_log_quest);
            tv_log_answer = itemView.findViewById(R.id.tv_log_answer);
            tv_log_ans_toggle = itemView.findViewById(R.id.tv_log_ans_toggle);
            layout_rv_hori = itemView.findViewById(R.id.layout_rv_hori);
        }
    }
}
