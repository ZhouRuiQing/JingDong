package com.bwie.jingdong.apdater;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.HomeBean;
import com.bwie.jingdong.mvp.model.bean.UiBean;;

import java.util.ArrayList;
import java.util.List;

public class Myapdater extends RecyclerView.Adapter<MyViewHoder> {
    Context context;
    List<UiBean.DataBean> list=new ArrayList<>();
    public Myapdater(Context context) {
        this.context = context;
    }

    public void addData(List<UiBean.DataBean> list,Boolean isFresh) {
        if (list != null) {

            if (isFresh) {

                this.list.clear();
            }
            this.list = list;
        }
    }

    public List<UiBean.DataBean>  getData() {
        return list;

    }

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHoder hoder = new MyViewHoder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        holder.iv_iamge.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
        holder.tv_title.setText(list.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
