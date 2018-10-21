package com.bwie.jingdong.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.jingdong.R;
import com.facebook.drawee.view.SimpleDraweeView;

class FenleiHoder  extends RecyclerView.ViewHolder {

    public SimpleDraweeView ivGrid;
    public TextView tvGridName;




    public FenleiHoder(View itemView) {
        super(itemView);
        ivGrid =  itemView.findViewById(R.id.iv_grid);
        tvGridName = itemView.findViewById(R.id.tv_grid_name);


    }
}
