package com.bwie.jingdong.apdater;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.bwie.jingdong.R;
import com.bwie.jingdong.inter.CartAllCheckLinstener;
import com.bwie.jingdong.inter.CheckListener;
import com.bwie.jingdong.mvp.model.bean.CartsBean;
import com.bwie.jingdong.mvp.view.cancvas.My_add_reduce;

import java.util.List;

class ProductApdater extends RecyclerView.Adapter<ProductViewHoder>{
    List<CartsBean.DataBean.ListBean> list;
    Context contex;
    private CheckListener checkListener;
    private CartAllCheckLinstener cartAllCheckLinstener;

    public ProductApdater(List<CartsBean.DataBean.ListBean> list, Context contex) {
        this.list = list;
        this.contex = contex;
    }

    public void setCheckListener(CheckListener checkListener) {
        this.checkListener = checkListener;
    }

    public void setCartAllCheckLinstener(CartAllCheckLinstener cartAllCheckLinstener) {
        this.cartAllCheckLinstener = cartAllCheckLinstener;
    }


    @NonNull
    @Override
    public ProductViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ProductViewHoder hoder = new ProductViewHoder(LayoutInflater.from(contex).inflate(R.layout.product_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHoder holder, int position) {
        final CartsBean.DataBean.ListBean bean = list.get(position);
        holder.ProcuctCheckbox.setChecked(bean.isSelected());
        holder.price.setText("优惠价:¥"+list.get(position).getBargainPrice());
        holder.tv_name.setText(list.get(position).getTitle());
        //holder.productIcon.setImageURI(Uri.parse(list.get(position).getImages().split("\\|")[0]));

        String[] split = bean.getImages().split("\\|");

        if(split!=null&&split.length>0){

            Glide.with(contex).load(split[0]).into(holder.productIcon);
        }else {
            holder.productIcon.setImageResource(R.mipmap.ic_launcher);
        }
        holder.ProcuctCheckbox.setChecked(bean.isSelected());

        holder.myAddReduce.setNumEt(bean.getTotalNum());
        holder.myAddReduce.setJiaJianLinstener(new My_add_reduce.JiaJianLinstener() {
            @Override
            public void getNum(int num) {
                bean.setTotalNum(num);
                if(checkListener!=null){
                    checkListener.notifyParpen();
                }
            }
        });

        holder.ProcuctCheckbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.ProcuctCheckbox.isChecked()){
                    bean.setSelected(true);
                }else{
                    bean.setSelected(false);
                }
                if (checkListener!=null){
                    checkListener.notifyParpen();
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size()==0?0:list.size() ;
    }


}
