package com.example.androidrecyclerviewdemo.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.androidrecyclerviewdemo.R;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    public static final int TYPE_FOOTER = 0;
    public static final int TYPE_NORMAL = 1;

    private View mFooterView;

    public List<String> datas = null;

    private OnItemActionClickListener onItemActionClickListener;

    private MyFootHolder myFootHolder;

    public MyAdapter(List<String> datas)
    {
        this.datas = datas;
    }

    public void setmFooterView(View mFooterView)
    {
        this.mFooterView = mFooterView;
        notifyItemInserted(datas.size());
    }

    public View getFooterView()
    {
        return mFooterView;
    }

    @Override
    public int getItemCount()
    {
        return datas.size()+1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int position)
    {

        if(viewHolder instanceof  MyViewHolder)
        {
            ImageLoader.getInstance().displayImage(datas.get(position), ((MyViewHolder) viewHolder).image);

            ((MyViewHolder) viewHolder).cardView.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    onItemActionClickListener.onItemActionClick(v, position);
                }
            });
        }
        else if(viewHolder instanceof MyFootHolder)
        {
            myFootHolder = ((MyFootHolder) viewHolder);
            ((MyFootHolder) viewHolder).progressBar.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int type)
    {
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
//        RecyclerView.ViewHolder vh = new MyViewHolder(view);
//        return vh;
        if (mFooterView != null && type == TYPE_FOOTER) return new MyFootHolder(mFooterView);
        View layout = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        return new MyViewHolder(layout);
    }

    /**
     * 添加数据
     *
     * @param datas
     */
    public void addDatas(ArrayList<String> datas)
    {
        datas.addAll(datas);
        notifyDataSetChanged();
    }

    public MyFootHolder getMyFootHolder()
    {
        return myFootHolder;
    }

    @Override
    public int getItemViewType(int position)
    {
        Log.e("wangkeke","position = "+position);
        if (mFooterView == null) return TYPE_NORMAL;
        if (position == datas.size()) return TYPE_FOOTER;
        return TYPE_NORMAL;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder
    {

        public ImageView image;

        private CardView cardView;

        public MyViewHolder(View itemView)
        {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.item_image);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }

    }

    @Override
    public void onViewAttachedToWindow(RecyclerView.ViewHolder holder)
    {
        super.onViewAttachedToWindow(holder);
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        if (lp != null
                && lp instanceof StaggeredGridLayoutManager.LayoutParams)
        {
            StaggeredGridLayoutManager.LayoutParams p = (StaggeredGridLayoutManager.LayoutParams) lp;
            p.setFullSpan(holder.getLayoutPosition() == datas.size());
        }
    }


    public static class MyFootHolder extends RecyclerView.ViewHolder
    {

        public ProgressBar progressBar;

        public MyFootHolder(View itemView)
        {
            super(itemView);

            progressBar = (ProgressBar) itemView.findViewById(R.id.progress);
        }

    }

    public void setOnItemActionListener(OnItemActionClickListener onItemActionClickListener)
    {
        this.onItemActionClickListener = onItemActionClickListener;
    }

    public interface OnItemActionClickListener
    {
        public void onItemActionClick(View view, int position);
    }

}
