package com.bwie.jingdong.apdater;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bwie.jingdong.R;
import com.bwie.jingdong.inter.CartAllCheckLinstener;
import com.bwie.jingdong.inter.CheckListener;
import com.bwie.jingdong.mvp.model.bean.CartsBean;
import com.jcodecraeer.xrecyclerview.ItemTouchHelperAdapter;

import java.util.Collections;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartViewHoder> implements CheckListener,ItemTouchHelperAdapter {
    Context contex;
    List<CartsBean.DataBean> list;
    private CheckListener checkListener;
    private CartAllCheckLinstener cartAllCheckLinstener;

    public CartAdapter(Context contex, List<CartsBean.DataBean> list) {
        this.contex = contex;
        this.list = list;

    }
    public List<CartsBean.DataBean> getCartList(){
        return list;
    }

    public void setCartAllCheckLinstener(CartAllCheckLinstener cartAllCheckLinstener) {
        this.cartAllCheckLinstener = cartAllCheckLinstener;
    }

    @NonNull
    @Override
    public CartViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CartViewHoder hoder  =new CartViewHoder(LayoutInflater.from(contex).inflate(R.layout.cart_item,parent,false));
        return hoder;
    }

    @Override
    public void onBindViewHolder(@NonNull final CartViewHoder holder, int position) {
        final CartsBean.DataBean bean = list.get(position);
        holder.shopCart.setText(list.get(position).getSellerName());

        holder.shopCartSelect.setChecked(bean.isSelected());

        holder.ProductRecyclerView.setLayoutManager(new LinearLayoutManager(contex));
        ProductApdater productApdater = new ProductApdater(bean.getList(),contex);

        holder.ProductRecyclerView.setAdapter(productApdater);

        productApdater.setCheckListener(this);


        for (int i = 0; i < bean.getList().size(); i++) {

            if(!bean.getList().get(i).isSelected()){
                holder.shopCartSelect.setChecked(false);
                break;
            }else{
                holder.shopCartSelect.setChecked(true);
            }
        }

        holder.shopCartSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.shopCartSelect.isChecked()){
                    bean.setSelected(true);
                    for (int i = 0; i < bean.getList().size(); i++) {
                        bean.getList().get(i).setSelected(true);
                    }
                }else{
                    bean.setSelected(false);
                    for (int i = 0; i < bean.getList().size(); i++) {
                        bean.getList().get(i).setSelected(false);
                    }
                }
                notifyDataSetChanged();
                if(cartAllCheckLinstener!=null){
                    cartAllCheckLinstener.notifyAllCheckboxStatus();
                }

            }
        });


    }

    @Override
    public int getItemCount() {
        return list.size()==0?0:list.size();
    }

    @Override
    public void notifyParpen() {

        notifyDataSetChanged();
        if (cartAllCheckLinstener!=null){
            cartAllCheckLinstener.notifyAllCheckboxStatus();
        }
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        Collections.swap(list,fromPosition,toPosition);
        notifyItemMoved(fromPosition,toPosition);
    }

    @Override
    public void onItemDismiss(int position) {

        list.remove(position);
        notifyItemRemoved(position);
    }
}
