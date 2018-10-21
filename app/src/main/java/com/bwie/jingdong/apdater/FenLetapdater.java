package com.bwie.jingdong.apdater;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.HomeBean;

import java.util.List;

public class FenLetapdater extends RecyclerView.Adapter<FenleiHoder> {
    Context context;
    List<HomeBean.DataBean.FenleiBean> list;

    public FenLetapdater(Context context, List<HomeBean.DataBean.FenleiBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public FenleiHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        FenleiHoder hoder = new FenleiHoder(LayoutInflater.from(context).inflate(R.layout.grid_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull FenleiHoder holder, int position) {

        holder.ivGrid.setImageURI(Uri.parse(list.get(position).getIcon()));
        holder.tvGridName.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
