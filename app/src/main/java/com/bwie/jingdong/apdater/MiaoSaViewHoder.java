package com.bwie.jingdong.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.jingdong.R;
import com.facebook.drawee.view.SimpleDraweeView;

class MiaoSaViewHoder extends RecyclerView.ViewHolder {

    public SimpleDraweeView ivImageMiaosa;
    public TextView tvTitleMiaosa;

    public MiaoSaViewHoder(View itemView) {
        super(itemView);

        ivImageMiaosa = itemView.findViewById(R.id.iv_image_miaosa);
        tvTitleMiaosa = itemView.findViewById(R.id.tv_title_miaosa);

    }
}
