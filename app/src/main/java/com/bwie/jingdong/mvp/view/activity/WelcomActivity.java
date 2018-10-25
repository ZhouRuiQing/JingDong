package com.bwie.jingdong.mvp.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.bwie.jingdong.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WelcomActivity extends AppCompatActivity {

    @BindView(R.id.welcome_tv)
    TextView welcomeTv;
    @BindView(R.id.welcome_jump)
    TextView welcomeJump;

    private int time=3;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1){
                time--;
                welcomeTv.setText(time+"");
                handler.sendEmptyMessageDelayed(1,1000);
                if (time == 0){
                    welcomeTv.setText(time+"");
                    handler.removeMessages(1);
                    startActivity(new Intent(WelcomActivity.this,MainActivity.class));
                    finish();
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcom);
        ButterKnife.bind(this);
        handler.sendEmptyMessageDelayed(1,1000);
    }


    @OnClick(R.id.welcome_jump)
    public void onViewClicked() {
        handler.removeMessages(1);
        startActivity(new Intent(WelcomActivity.this,MainActivity.class));
        finish();
    }

}
