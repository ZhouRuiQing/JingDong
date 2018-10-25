package com.bwie.jingdong.mvp.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.bwie.jingdong.IView.IMainView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.apdater.Myapdater;
import com.bwie.jingdong.apdater.ShowApdater;
import com.bwie.jingdong.mvp.model.bean.UiBean;
import com.bwie.jingdong.mvp.present.MainPresent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShowActivity extends AppCompatActivity implements IMainView {

    @BindView(R.id.search_recycler_View)
    RecyclerView searchRecyclerView;
    private MainPresent present;
    private ShowApdater myapdater;
    private LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ButterKnife.bind(this);

        present = new MainPresent(this);
        String s = getIntent().getStringExtra("s");
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        present.getdatas(s,1,"0");
    }



    @Override
    public void onSuccess(List<UiBean.DataBean> list) {
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        searchRecyclerView.setLayoutManager(layoutManager);
        myapdater = new ShowApdater(this,list);
        searchRecyclerView.setAdapter(myapdater);
    }

    @Override
    public void onErr(String errMsg) {

    }
}
