package com.example.androidrecyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidrecyclerviewdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyRecAdapter extends StaggeredGridLayoutAdapter{


    public MyRecAdapter(List<String> list, int headerViewRes) {
        super(list, headerViewRes);
    }

    public MyRecAdapter(List<String> list) {
        super(list);
    }

    public MyRecAdapter(List<String> list, int headerViewRes, int footerViewRes) {
        super(list, headerViewRes, footerViewRes);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    protected void onBindHeaderView(View headerView) {
        //这是HeadView数据绑定的过程
    }

    @Override
    protected void onBindFooterView(View footerView) {
        //这是FootView数据绑定的过程
    }

    @Override
    protected void onBindItemView(RecyclerView.ViewHolder holder, String item)
    {
        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        Picasso.with(holder.itemView.getContext()).load(item).into(itemViewHolder.icon);
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        ImageView icon;
        public ItemViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.item_image);
        }
    }
}
