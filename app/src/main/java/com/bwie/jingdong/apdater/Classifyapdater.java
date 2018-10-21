package com.bwie.jingdong.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.HomeBean;

import java.util.List;

public class Classifyapdater extends RecyclerView.Adapter<ClassifyViewHoder> {
    Context context;
    List<HomeBean.DataBean.FenleiBean> list;

    public Classifyapdater(Context context, List<HomeBean.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ClassifyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ClassifyViewHoder hoder = new ClassifyViewHoder(LayoutInflater.from(context).inflate(R.layout.class_ify_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull ClassifyViewHoder holder, final int position) {

        holder.ify_name.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onCatagoryLisenter!=null){

                    onCatagoryLisenter.onNameClick(list.get(position).getCid());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnCatagoryLisenter {
        void onNameClick(int cid);
    }

    private OnCatagoryLisenter onCatagoryLisenter;

    public void setOnCatagoryLisenter(OnCatagoryLisenter onCatagoryLisenter) {
        this.onCatagoryLisenter = onCatagoryLisenter;
    }


}
