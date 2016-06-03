package com.example.androidrecyclerviewdemo.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by wangkeke on 2016/6/2.
 * ��ע��
 */
public abstract class RecyclerViewAdapter<T extends String> extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{

    /**
     * 不同的布局类型，0代表头部，1代表尾部，2代表普通布局
     */
    public interface Item
    {
        int TYPE_HEADER = 0;
        int TYPE_FOOTER = 1;
        int TYPE_NORMAL = 2;
    }

    //数据源
    private List<T> list = null;

    //头部layout资源id
    private int headerViewRes;

    //尾部layout资源id
    private int footerViewRes;

    //当前是否有头
    private boolean hasHeader = false;

    //当前是否有尾
    private boolean hasFooter = false;

    public List<T> getList()
    {
        return list;
    }

    public void setList(List<T> list)
    {
        this.list = list;
    }

    /**
     * 判断position位置的item是否是头head
     * @param position
     * @return
     */
    public boolean isHeader(int position)
    {
        return hasHeader() && position == 0;
    }

    /**
     * 判断position位置的item是否是尾foot
     * @param position
     * @return
     */
    public boolean isFooter(int position)
    {
        if (hasHeader())
        {
            return hasFooter() && position == list.size() + 1;
        } else
        {
            return hasFooter() && position == list.size();
        }
    }

    public boolean hasHeader()
    {
        return hasHeader;
    }

    public boolean hasFooter()
    {
        return hasFooter;
    }


    public int getHeaderView()
    {
        return headerViewRes;
    }

    public int getFooterView()
    {
        return footerViewRes;
    }

    /**
     * 设置头部layout布局文件
     *
     * @param headerViewRes
     */
    public void setHeaderView(int headerViewRes)
    {
        if (headerViewRes != 0)
        {
            if (!hasHeader())
            {
                this.headerViewRes = headerViewRes;
                this.hasHeader = true;
                notifyItemInserted(0);
            } else
            {
                this.headerViewRes = headerViewRes;
                notifyDataSetChanged();
            }
        } else
        {
            if (hasHeader())
            {
                this.hasHeader = false;
                notifyItemRemoved(0);
            }
        }
    }

    /**
     * 设置尾部layout布局文件
     *
     * @param footerViewRes
     */
    public void setFooterView(int footerViewRes)
    {
        if (footerViewRes != 0)
        {
            if (!hasFooter())
            {
                this.footerViewRes = footerViewRes;
                this.hasFooter = true;
                if (hasHeader())
                {
                    notifyItemInserted(list.size() + 1);
                } else
                {
                    notifyItemInserted(list.size());
                }
            } else
            {
                this.footerViewRes = footerViewRes;
                notifyDataSetChanged();
            }

        } else
        {
            if (hasFooter())
            {
                this.hasFooter = false;
                if (hasHeader())
                {
                    notifyItemRemoved(list.size() + 1);
                } else
                {
                    notifyItemRemoved(list.size());
                }
            }
        }
    }

    /**
     * 构造函数
     * @param list
     */
    public RecyclerViewAdapter(List<T> list) {
        this.list = list;
    }

    /**
     * 构造函数
     * @param list
     * @param headerViewRes
     */
    public RecyclerViewAdapter(List<T> list, int headerViewRes) {
        this.list = list;
        setHeaderView(headerViewRes);
    }

    /**
     * 构造函数
     * @param list
     * @param headerViewRes
     * @param footerViewRes
     */
    public RecyclerViewAdapter(List<T> list, int headerViewRes,int footerViewRes)
    {
        this.list = list;
        setHeaderView(headerViewRes);
        setFooterView(footerViewRes);
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        /**
         * 根据不同的类型加载不同的ViewHolder
         */
        if (hasHeader() && viewType == Item.TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(getHeaderView(), parent, false);
            return new HeaderViewHolder(v);
        } else if (hasFooter() && viewType == Item.TYPE_FOOTER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(getFooterView(), parent, false);
            return new FooterViewHolder(v);
        } else {
            return onCreateHolder(parent, viewType);
        }
    }

    /*以下是抽象出来的公共方法，用于实现普通布局的处理*/

    public abstract RecyclerView.ViewHolder onCreateHolder(ViewGroup parent, int viewType);

    protected abstract void onBindHeaderView(View headerView);

    protected abstract void onBindFooterView(View footerView);

    protected abstract void onBindItemView(RecyclerView.ViewHolder holder, T item);

    /*抽象结束*/

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position)
    {
        /**
         * 根据类型来绑定数据
         */

        if (getItemViewType(position) == Item.TYPE_HEADER) {
            HeaderViewHolder headerHolder = (HeaderViewHolder) holder;
            View headerView = headerHolder.itemView;

            onBindHeaderView(headerView);
        } else if (getItemViewType(position) == Item.TYPE_FOOTER) {
            FooterViewHolder footerHolder = (FooterViewHolder) holder;
            View footerView = footerHolder.itemView;

            onBindFooterView(footerView);
        } else {
            T i = getItemByPosition(position);
            onBindItemView(holder, i);

        }
    }

    /**
     * 返回item数量
     * @return
     */
    @Override
    public int getItemCount() {
        int count = 0;
        count += (hasHeader() ? 1 : 0);
        count += (hasFooter() ? 1 : 0);
        count += list.size();
        return count;
    }

    /**
     * 获取position位置的数据值
     * @param position
     * @return
     */
    protected T getItemByPosition(int position) {
        if (hasHeader()) {
            return list.get(position - 1);
        } else {
            return list.get(position);
        }
    }


    @Override
    public int getItemViewType(int position)
    {
        int size = list.size();
        if (hasHeader()) {
            //包含头部并且position为0时返回Header类型
            if (position == 0) {
                return Item.TYPE_HEADER;
            } else {
                if (position == size + 1) {
                    return Item.TYPE_FOOTER;
                } else {
                    return Item.TYPE_NORMAL;
                }
            }

        } else {
            if (position == size) {
                return Item.TYPE_FOOTER;
            } else {
                return Item.TYPE_NORMAL;
            }
        }
    }

    /**
     * 头部viewhodler
     */
    static class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }

    /**
     * 尾部viewhodler
     */
    static class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }

}








































