package com.example.androidrecyclerviewdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class HomeActivity extends AppCompatActivity
{
    public static final String KEY_TYPE = "type";

    public static final int LINEAR_TYPE = 1;
    public static final int GRID_TYPE = 2;
    public static final int STAG_TYPE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initView();
    }

    private void initView()
    {
        findViewById(R.id.button_linear).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                jumpMainActivity(LINEAR_TYPE);
            }
        });

        findViewById(R.id.button_grid).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                jumpMainActivity(GRID_TYPE);
            }
        });

        findViewById(R.id.button_stag).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                jumpMainActivity(STAG_TYPE);
            }
        });
    }

    private void jumpMainActivity(int type)
    {
        Intent intent = new Intent(HomeActivity.this,MainActivity.class);
        intent.putExtra(KEY_TYPE,type);
        startActivity(intent);
    }
}
