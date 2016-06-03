package com.example.androidrecyclerviewdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PersistableBundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import com.example.androidrecyclerviewdemo.adapter.LinearLayoutAdapter;
import com.example.androidrecyclerviewdemo.adapter.MyGridAdapter;
import com.example.androidrecyclerviewdemo.adapter.MyLinearAdapter;
import com.example.androidrecyclerviewdemo.adapter.MyRecAdapter;
import com.example.androidrecyclerviewdemo.adapter.RecyclerViewAdapter;
import com.example.androidrecyclerviewdemo.listener.OnRecyclerViewScrollListener;

public class MainActivity extends Activity
{
    private RecyclerView recyclerView;

    List<String> datas = new ArrayList<String>();
//    private MyGridAdapter adapter;
//    private MyRecAdapter adapter;
    RecyclerViewAdapter adapter;

    List<String> arrayList;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            List<String> list= (List<String>) msg.obj;
            adapter.getList().addAll(list);
            adapter.notifyDataSetChanged();
            adapter.setFooterView(0);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState)
    {
        super.onCreate(savedInstanceState, persistentState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView()
    {

        initData();

        int type = getIntent().getIntExtra(HomeActivity.KEY_TYPE,HomeActivity.LINEAR_TYPE);
        recyclerView = (RecyclerView) findViewById(R.id.rv_view);

        switch (type)
        {
            case HomeActivity.LINEAR_TYPE:
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
                recyclerView.setLayoutManager(linearLayoutManager);
                adapter =  new MyLinearAdapter(datas);

                break;
            case HomeActivity.GRID_TYPE:
                GridLayoutManager gridManager = new GridLayoutManager(this,2);
                recyclerView.setLayoutManager(gridManager);
                adapter =  new MyGridAdapter(datas);
                break;
            case HomeActivity.STAG_TYPE:
                StaggeredGridLayoutManager stagManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
                recyclerView.setLayoutManager(stagManager);
                adapter =  new MyRecAdapter(datas);
                break;
        }

        recyclerView.setHasFixedSize(true);

        arrayList=new ArrayList<String>(adapter.getList());

        recyclerView.addOnScrollListener(new OnRecyclerViewScrollListener<String>(){
            @Override
            public void onStart() {
                adapter.setFooterView(R.layout.footer);
                if (adapter.hasHeader()){
                    recyclerView.smoothScrollToPosition(adapter.getItemCount()+1);
                }else{
                    recyclerView.smoothScrollToPosition(adapter.getItemCount());
                }
            }

            @Override
            public void onLoadMore() {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(3000);
                            //手动调用onFinish()
                            onFinish(arrayList);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
            }

            @Override
            public void onFinish(List<String> contents) {
                Message message=Message.obtain();
                message.obj=contents;
                handler.sendMessage(message);
                setLoadingMore(false);
            }
        });

        /*recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {

            //用来标记是否正在向最后一个滑动，既是否向下滑动
            boolean isSlidingToLast = false;

            @Override
            protected Object clone() throws CloneNotSupportedException
            {
                return super.clone();
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
            {
                StaggeredGridLayoutManager manager = (StaggeredGridLayoutManager) recyclerView.getLayoutManager();
                // 当不滚动时
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    //获取最后一个完全显示的ItemPosition
                    int[] lastVisiblePositions = manager.findLastVisibleItemPositions(new int[manager.getSpanCount()]);
                    int lastVisiblePos = getMaxElem(lastVisiblePositions);
                    int totalItemCount = manager.getItemCount();

                    // 判断是否滚动到底部
                    if (lastVisiblePos == (totalItemCount -1) && isSlidingToLast) {
                        //加载更多功能的代码
                        Toast.makeText(MainActivity.this,"加载更多",Toast.LENGTH_LONG).show();


                    }

                }


            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                super.onScrolled(recyclerView, dx, dy);
                //dx用来判断横向滑动方向，dy用来判断纵向滑动方向
                if(dy > 0){
                    //大于0表示，正在向下滚动
                    isSlidingToLast = true;
                }else{
                    //小于等于0 表示停止或向上滚动
                    isSlidingToLast = false;
                }

            }
        });*/

//        adapter.setFooterView(R.layout.footer);
       /* adapter.setOnItemActionListener(new MyAdapter.OnItemActionClickListener()
        {
            @Override
            public void onItemActionClick(View view, int position)
            {
                Toast.makeText(MainActivity.this, "您点击了pos = " + position, Toast.LENGTH_SHORT).show();
            }
        });*/

//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL_LIST);
//        recyclerView.addItemDecoration(dividerItemDecoration);

        recyclerView.setAdapter(adapter);

    }

    private void initData()
    {
        for (int i = 0; i < ImageUtils.IMAGE_URL.length; i++)
        {
            datas.add(ImageUtils.IMAGE_URL[i]);
        }
    }

    private int getMaxElem(int[] arr)
    {
        int size = arr.length;
        int maxVal = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++)
        {
            if (arr[i] > maxVal)
                maxVal = arr[i];
        }
        return maxVal;
    }

}
