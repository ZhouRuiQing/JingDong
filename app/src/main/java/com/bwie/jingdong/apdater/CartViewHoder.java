package com.bwie.jingdong.apdater;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bwie.jingdong.R;

class CartViewHoder extends RecyclerView.ViewHolder {

    public CheckBox shopCartSelect;
    public TextView shopCart;
    public RecyclerView ProductRecyclerView;

    public CartViewHoder(View itemView) {
        super(itemView);


        shopCartSelect = itemView.findViewById(R.id.shop_Cart_select);
        shopCart = itemView. findViewById(R.id.shop_cart);
        ProductRecyclerView = itemView. findViewById(R.id.Product_Recycler_View);

    }
}
