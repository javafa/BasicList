package com.baekcedar.android.basiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by HM on 2016-09-28.
 */
public class RecyclerAnimationAdapter extends RecyclerView.Adapter<RecyclerAnimationAdapter.ViewHolder>{

    ArrayList<RecyclerData> datas;
    int itemLayout;
    Context context;

    public RecyclerAnimationAdapter(ArrayList<RecyclerData> datas, int itemLayout, Context context){
        this.datas = datas;
        this.itemLayout = itemLayout;
        this.context = context;
    }

    // view 를 만들어서 홀더에 저장하는 역할
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(view);
    }

    // listView getView 를 대체하는 함수
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        RecyclerData data = datas.get(position);
        holder.img.setBackgroundResource(data.image);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"이미지가 클릭됨!!!",Toast.LENGTH_SHORT).show();
            }
        });
        holder.textTitle.setText(data.title);
        holder.textName.setText(data.name);
        holder.itemView.setTag(data);
        holder.clickToDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, RecyclerDetailActivity.class);
                intent.putExtra("position", position);
                context.startActivity(intent);
            }
        });

        setAnimation(holder.img, position);
    }


    int lastPosition = -1;
    public void setAnimation(View view, int position){

        if(position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            view.startAnimation(animation);
            lastPosition = position;
        }
    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView textTitle;
        TextView textName;
        RelativeLayout clickToDetail;

        public ViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textName = (TextView) itemView.findViewById(R.id.textName);
            clickToDetail = (RelativeLayout) itemView.findViewById(R.id.clickToDetail);
        }
    }
}
