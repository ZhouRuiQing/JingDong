package com.bwie.jingdong.apdater;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.HomeBean;
import com.bwie.jingdong.mvp.model.bean.UiBean;
import com.bwie.jingdong.mvp.view.activity.PartiCularsActivity;;

import java.util.List;

public class Myapdater extends RecyclerView.Adapter<MyViewHoder> {
    Context context;
    List<HomeBean.DataBean.TuijianBean.ListBeanX> list;
    public Myapdater(Context context, List<HomeBean.DataBean.TuijianBean.ListBeanX> list) {
        this.context=context;
        this.list=list;
    }

   /* public void addData(List<HomeBean.DataBean.TuijianBean.ListBeanX> list,Boolean isFresh) {
        if (list != null) {

            if (isFresh) {
                this.list.clear();
            }
            this.list = list;
        }
    }

    public List<HomeBean.DataBean.TuijianBean.ListBeanX>  getData() {
        return list;

    }*/

    @NonNull
    @Override
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        MyViewHoder hoder = new MyViewHoder(LayoutInflater.from(context).inflate(R.layout.item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHoder holder, final int position) {
        holder.iv_iamge.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));
        holder.tv_title.setText(list.get(position).getTitle());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,PartiCularsActivity.class);
                intent.putExtra("pid",list.get(position).getPid());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
