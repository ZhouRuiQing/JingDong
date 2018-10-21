package com.bwie.jingdong.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.jingdong.R;


class MyViewHoder extends RecyclerView.ViewHolder {

    public  ImageView iv_iamge;
    public  TextView  tv_title;

    public MyViewHoder(View itemView) {
        super(itemView);

        iv_iamge = itemView.findViewById(R.id.iv_image);
        tv_title = itemView.findViewById(R.id.tv_title);
    }
}
