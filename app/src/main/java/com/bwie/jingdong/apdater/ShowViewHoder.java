package com.bwie.jingdong.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bwie.jingdong.R;

class ShowViewHoder extends RecyclerView.ViewHolder {
    public ImageView iv_iamge;
    public TextView tv_title;

    public ShowViewHoder(View itemView) {
        super(itemView);

        iv_iamge = itemView.findViewById(R.id.iv_images);
        tv_title = itemView.findViewById(R.id.tv_titles);
    }
}
