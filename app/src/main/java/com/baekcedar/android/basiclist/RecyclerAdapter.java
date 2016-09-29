package com.baekcedar.android.basiclist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by HM on 2016-09-28.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{

    ArrayList<RecyclerData> datas;
    int itemLayout;

    public RecyclerAdapter(ArrayList<RecyclerData> datas, int itemLayout){
        this.datas = datas;
        this.itemLayout = itemLayout;
    }


    // view 를 만들어서 홀더에 저장하는 역할
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);

        return new ViewHolder(view);
    }

    // listView getView 를 대체하는 함수
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RecyclerData data = datas.get(position);

        holder.img.setBackgroundResource(data.image);
        holder.textTitle.setText(data.title);
        holder.textName.setText(data.name);
        holder.itemView.setTag(data);

    }


    @Override
    public int getItemCount() {
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView textTitle;
        TextView textName;

        public ViewHolder(View itemView) {
            super(itemView);

            img = (ImageView) itemView.findViewById(R.id.img);
            textTitle = (TextView) itemView.findViewById(R.id.textTitle);
            textName = (TextView) itemView.findViewById(R.id.textName);
        }
    }
}
