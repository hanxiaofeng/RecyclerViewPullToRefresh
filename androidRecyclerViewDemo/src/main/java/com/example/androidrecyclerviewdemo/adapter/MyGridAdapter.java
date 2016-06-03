package com.example.androidrecyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.androidrecyclerviewdemo.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyGridAdapter extends GridLayoutAdapter{


    public MyGridAdapter(List<String> list, int headerViewRes) {
        super(list, headerViewRes);
    }

    public MyGridAdapter(List<String> list) {
        super(list);
    }

    public MyGridAdapter(List<String> list, int headerViewRes, int footerViewRes) {
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
//        ImageView imageView= (ImageView) headerView.findViewById(R.id.icon);
//        Picasso.with(headerView.getContext()).load("http://img.my.csdn.net/uploads/201508/05/1438760758_3497.jpg").into(imageView);
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
