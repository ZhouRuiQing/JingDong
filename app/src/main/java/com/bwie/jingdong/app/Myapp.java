package com.bwie.jingdong.app;

import android.app.Application;
import android.os.Build;
import android.os.StrictMode;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.uuzuche.lib_zxing.activity.ZXingLibrary;

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        initLoder();
        initzxing();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());
        }
    }

    private void initzxing() {

        ZXingLibrary.initDisplayOpinion(this);
    }

    private void initLoder() {
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration
                .Builder(getApplicationContext())
                .defaultDisplayImageOptions(createOption())
                .build();
        ImageLoader.getInstance().init(configuration);


    }

    private DisplayImageOptions createOption() {

        DisplayImageOptions options = new DisplayImageOptions
                .Builder()
                .cacheInMemory(true)    // 开启内存缓存
                .cacheOnDisk(true)      // 开启存储卡缓存
                .build();
        return options;

    }
}
