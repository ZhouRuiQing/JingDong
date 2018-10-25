package com.bwie.jingdong.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bwie.jingdong.IView.IRegView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.UserReg;
import com.bwie.jingdong.mvp.present.PresentReg;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class UserSetActivity extends AppCompatActivity implements IRegView {

    @BindView(R.id.edit_name_reg)
    EditText editNameReg;
    @BindView(R.id.edit_password_reg)
    EditText editPasswordReg;
    @BindView(R.id.but_reg_Reg)
    Button butRegReg;
    private PresentReg presentReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_set);
        ButterKnife.bind(this);

        presentReg = new PresentReg(this);
    }

    @OnClick(R.id.but_reg_Reg)
    public void onClickView(){
        String mobile = editNameReg.getText().toString();
        String password = editPasswordReg.getText().toString();
        presentReg.getReg(mobile,password);
    }

    @Override
    public void RegSuccess(UserReg userReg) {

        if(userReg.getCode().equals("1")){

            Toast.makeText(this,"注册失败",Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(this,"注册成功",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,LoginActivity.class));
            finish();
        }

    }
}
