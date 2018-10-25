package com.bwie.jingdong.mvp.view.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.jingdong.IView.LoginView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.LoginBean;
import com.bwie.jingdong.mvp.present.PresentLogin;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.edit_name)
    EditText editName;
    @BindView(R.id.edit_password)
    EditText editPassword;
    @BindView(R.id.but_login)
    Button butLogin;
    @BindView(R.id.but_reg)
    TextView butReg;
    private PresentLogin presentLogin;
    private SharedPreferences user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        presentLogin = new PresentLogin(this);

    }

    @OnClick({R.id.but_login,R.id.but_reg})
    public void   onViewClicked(View view){
        switch (view.getId()){

            case R.id.but_login:
                String mobile = editName.getText().toString();
                String password = editPassword.getText().toString();
                presentLogin.getLogin(mobile,password);
                break;
            case R.id.but_reg:
                startActivity(new Intent(this,UserSetActivity.class));
                finish();
                break;
        }
    }

    @Override
    public void LoginSuccess(LoginBean loginBean) {

        if(loginBean.getCode().equals("1")){

            Toast.makeText(this,"登录失败 用户名或密码错误",Toast.LENGTH_SHORT).show();
        }else {

            Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show();
            user = getSharedPreferences("user", MODE_PRIVATE);
            String uid = String.valueOf(loginBean.getData().getUid());
            String username = loginBean.getData().getUsername();
            String token = loginBean.getData().getToken();

            user.edit().putString("uid",uid).commit();
            user.edit().putString("username",username).commit();
            user.edit().putString("token",token).commit();
            finish();
        }
    }
}
