package com.bwie.jingdong.apdater;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.HomeBean;

import java.util.List;

public class MiaoSaApdater extends RecyclerView.Adapter<MiaoSaViewHoder> {
    Context context;
    List<HomeBean.DataBean.MiaoshaBean.ListBean> list;

    public MiaoSaApdater(Context context, List<HomeBean.DataBean.MiaoshaBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MiaoSaViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MiaoSaViewHoder hoder = new MiaoSaViewHoder(LayoutInflater.from(context).inflate(R.layout.miao_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MiaoSaViewHoder holder, int position) {

        holder.ivImageMiaosa.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
        holder.tvTitleMiaosa.setText(list.get(position).getPrice()+"");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
