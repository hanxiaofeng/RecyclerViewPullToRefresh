package com.example.androidrecyclerviewdemo.adapter;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wangkeke on 2016/6/3.
 * ±¸×¢£º
 */
public abstract class LinearLayoutAdapter extends RecyclerViewAdapter
{

    public LinearLayoutAdapter(List list)
    {
        super(list);
    }

    public LinearLayoutAdapter(List list, int headerViewRes)
    {
        super(list, headerViewRes);
    }

    public LinearLayoutAdapter(List list, int headerViewRes, int footerViewRes)
    {
        super(list, headerViewRes, footerViewRes);
    }
}
