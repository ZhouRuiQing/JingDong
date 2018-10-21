package com.bwie.jingdong.mvp.view.cancvas;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.jingdong.R;

import io.reactivex.annotations.Nullable;

public class My_add_reduce extends LinearLayout {
    private TextView jiaTv,jiantv;
    private EditText numEt;
    private int num = 1;
    public My_add_reduce(Context context) {
        this(context,null);
    }

    public My_add_reduce(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public My_add_reduce(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.num_layout, this, true);
        jiantv = view.findViewById( R.id.jian);
        jiaTv = view.findViewById(R.id.jia);
        numEt = view.findViewById(R.id.num);

        numEt.setText(num+"");

        jiaTv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num++;
                numEt.setText(num+"");
                if(jiaJianLinstener!=null){
                    jiaJianLinstener.getNum(num);
                }
            }
        });
        jiantv.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                num--;
                if(num<=0){
                    Toast.makeText(getContext(),"数量不能小于1" , Toast.LENGTH_SHORT).show();
                    num=1;
                }
                numEt.setText(num+"");
                if(jiaJianLinstener!=null){
                    jiaJianLinstener.getNum(num);
                }
            }


        });
    }
    public void setNumEt(int n){
        numEt.setText(n+"");
        num = Integer.parseInt(numEt.getText().toString());
    }
    private JiaJianLinstener jiaJianLinstener;

    public void setJiaJianLinstener(JiaJianLinstener jiaJianLinstener) {
        this.jiaJianLinstener = jiaJianLinstener;
    }

    public interface JiaJianLinstener{
        void getNum(int num);
    }
}
