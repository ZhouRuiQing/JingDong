package com.bwie.jingdong.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.bwie.jingdong.R;

class ClassifyViewHoder extends RecyclerView.ViewHolder {

    public final TextView ify_name;

    public ClassifyViewHoder(View itemView) {
        super(itemView);

        ify_name = itemView.findViewById(R.id.ify_name_item);
    }
}
