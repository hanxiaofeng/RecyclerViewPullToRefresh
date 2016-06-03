package com.example.androidrecyclerviewdemo;

import java.io.File;
import java.io.IOException;

import android.app.Application;
import android.content.Context;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

public class MyApplication extends Application
{
    @Override
    public void onCreate()
    {
        super.onCreate();
        initImageLoader(this);
    }
    

    @SuppressWarnings("deprecation")
    private void initImageLoader(Context context)
    {
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisc(true).build();
        
        File f = new File(Environment.getExternalStorageDirectory().getAbsolutePath());
        if(!f.exists())
        {
            try
            {
                f.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
//        File f = this.getExternalCacheDir();
        
        ImageLoaderConfiguration config =
            new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2).memoryCache(new WeakMemoryCache()).discCache(new UnlimitedDiskCache(f))
            // .discCacheFileNameGenerator(new Md5FileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                .imageDownloader(new BaseImageDownloader(this, 5 * 10000, 30 * 1000))
                .defaultDisplayImageOptions(defaultOptions)
                .build();
        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
}
