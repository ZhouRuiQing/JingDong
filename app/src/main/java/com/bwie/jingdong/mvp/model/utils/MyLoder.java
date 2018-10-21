package com.bwie.jingdong.mvp.model.utils;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.youth.banner.loader.ImageLoader;

public class MyLoder extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        imageView.setImageURI(Uri.parse((String) path));
    }

    @Override
    public ImageView createImageView(Context context) {
        return new SimpleDraweeView(context);

    }
}
