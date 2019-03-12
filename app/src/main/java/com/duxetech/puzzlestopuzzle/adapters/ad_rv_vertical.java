package com.duxetech.puzzlestopuzzle.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duxetech.puzzlestopuzzle.R;

import java.util.List;

/**
 * Created by Karthik Swamy on 10-12-2018.
 */
public class ad_rv_vertical extends RecyclerView.Adapter<ad_rv_vertical.ViewHolder> {
    Context context;
    Class cl;

    public ad_rv_vertical(Context context, List<String> list, Class a) {
        this.context = context;
        this.list = list;
        this.cl = a;
    }

    List<String> list;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.items_rv_linear,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        holder.tv_no.setText(String.valueOf(i+1));
        holder.tv.setText(list.get(i));
        holder.log_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, cl);
                intent.putExtra("id",i);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv, tv_no;
        LinearLayout log_layout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.tv_rv_item);
            log_layout = itemView.findViewById(R.id.log_layout);
            tv_no = itemView.findViewById(R.id.tv_rv_no);

        }
    }
}
