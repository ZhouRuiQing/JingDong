package com.bwie.jingdong.apdater;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.bwie.jingdong.R;
import com.bwie.jingdong.mvp.model.bean.ProductCatagory;
import com.bwie.jingdong.mvp.view.activity.PartiCularsActivity;
import com.bwie.jingdong.mvp.view.activity.ProductsActivity;
import com.bwie.jingdong.mvp.view.cancvas.MyGridView;

import java.util.List;

public class ExApdater extends BaseExpandableListAdapter {
    List<ProductCatagory.DataBean> list;
    public ExApdater(List<ProductCatagory.DataBean> list) {
        this.list=list;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if(convertView==null){

            convertView = View.inflate(parent.getContext(), R.layout.group_item, null);
        }
        TextView group_name = convertView.findViewById(R.id.group_name);

         group_name.setText(list.get(groupPosition).getName());

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if(convertView==null){

            convertView = View.inflate(parent.getContext(), R.layout.grit_item, null);
        }
        //二级item加载一个gridview布局
        MyGridView grid = convertView.findViewById(R.id.grid);
        List<ProductCatagory.DataBean.ListBean> listBeans = this.list.get(groupPosition).getList();
        //为gridview设置条目点击监听
        grid.setAdapter(new GridApdater(listBeans));

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(parent.getContext(), ProductsActivity.class);
                intent.putExtra("pscid", list.get(position).getPcid());
                parent.getContext().startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
