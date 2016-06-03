package com.example.androidrecyclerviewdemo.adapter;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.androidrecyclerviewdemo.R;
import com.example.androidrecyclerviewdemo.adapter.LinearLayoutAdapter;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by wangkeke on 2016/6/3.
 * ±¸×¢£º
 */
public class MyLinearAdapter extends LinearLayoutAdapter
{
    public MyLinearAdapter(List list)
    {
        super(list);
    }

    public MyLinearAdapter(List list, int headerViewRes)
    {
        super(list, headerViewRes);
    }

    public MyLinearAdapter(List list, int headerViewRes, int footerViewRes)
    {
        super(list, headerViewRes, footerViewRes);
    }

    @Override
    public RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    protected void onBindHeaderView(View headerView)
    {

    }

    @Override
    protected void onBindFooterView(View footerView)
    {

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
