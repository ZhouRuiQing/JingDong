package com.bwie.jingdong.mvp.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bwie.jingdong.R;
import com.fyales.tagcloud.library.TagBaseAdapter;
import com.fyales.tagcloud.library.TagCloudLayout;

import java.util.ArrayList;
import java.util.List;

public class FloawActivity extends AppCompatActivity {

    private Button but;
    private List<String> list = new ArrayList<>();
    private TagCloudLayout mContainer;
    private ArrayList<String> mList;
    private TagBaseAdapter mAdapter;
    private EditText edt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_floaw);

        edt = findViewById(R.id.edt);
        mContainer = findViewById(R.id.container);
        mList = new ArrayList<>();
        mAdapter = new TagBaseAdapter(this, mList);
        but = findViewById(R.id.but_sousuo);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edt.getText().toString();
                mList.add(s);
                mAdapter.notifyDataSetChanged();
            }
        });
        mContainer.setAdapter(mAdapter);
        mContainer.setItemClickListener(new TagCloudLayout.TagItemClickListener() {
            @Override
            public void itemClick(int position) {

                Intent intent = new Intent(FloawActivity.this, ShowActivity.class);
                String s = edt.getText().toString();
                intent.putExtra("s",s);
                startActivity(intent);
            }
        });

    }
}
