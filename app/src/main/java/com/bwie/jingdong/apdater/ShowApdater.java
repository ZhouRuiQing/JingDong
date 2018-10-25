package com.bwie.jingdong.apdater;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.UiBean;
import com.bwie.jingdong.mvp.view.activity.PartiCularsActivity;
import com.bwie.jingdong.mvp.view.activity.ShowActivity;

import java.util.List;

public class ShowApdater extends RecyclerView.Adapter<ShowViewHoder> {
    Context context;
    List<UiBean.DataBean> list;

    public ShowApdater(Context context, List<UiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public ShowViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ShowViewHoder hoder = new ShowViewHoder(LayoutInflater.from(context).inflate(R.layout.sousuo_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ShowViewHoder holder, final int position) {
        holder.iv_iamge.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
        holder.tv_title.setText(list.get(position).getTitle());
/*
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PartiCularsActivity.class);
                intent.putExtra("url",list.get(position).getDetailUrl());
                context.startActivity(intent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
