package com.bwie.jingdong.fregment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.jingdong.IView.HomeView;
import com.bwie.jingdong.IView.LoginView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.apdater.Myapdater;
import com.bwie.jingdong.mvp.model.bean.HomeBean;
import com.bwie.jingdong.mvp.model.bean.LoginBean;
import com.bwie.jingdong.mvp.present.HomePresent;
import com.bwie.jingdong.mvp.present.PresentLogin;
import com.bwie.jingdong.mvp.view.activity.LoginActivity;
import com.bwie.jingdong.mvp.view.activity.PresonActivity;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment implements LoginView, HomeView {


    @BindView(R.id.my_icon)
    SimpleDraweeView myIcon;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.my_head)
    RelativeLayout myHead;
    Unbinder unbinder;
    @BindView(R.id.recycler_View_TuiJian)
    RecyclerView recyclerViewTuiJian;
    private SharedPreferences preferences;
    private GridLayoutManager layoutManager;
    private Myapdater apdater;
    private HomePresent homePresent;
    private PresentLogin presentLogin;
    private Bitmap head;// 头像Bitmap
    private static String path = "/sdcard/myHead/";// sd路径


    public MyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
       initData();
        myHead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), LoginActivity.class));
            }
        });
        return view;
    }

    private void initData() {

        homePresent = new HomePresent(this);
        homePresent.getHome();
        presentLogin = new PresentLogin(this);
    }


    @Override
    public void LoginSuccess(LoginBean loginBean) {
        LoginBean.DataBean data = loginBean.getData();
        myName.setText(data.getUsername());
    }

    @Override
    public void onResume() {
        super.onResume();

        preferences = getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        myHead.setBackgroundResource(R.drawable.loginafter);
        //设置本地图片
        myIcon.setActualImageResource(R.drawable.user);
        String username = preferences.getString("username", "");
        String token = preferences.getString("token", "");
        String head = preferences.getString("image", "");
        Log.i("rrr",username+"");
        myName.setText(username);
        if(token!=null){
            //Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();
            //http://120.27.23.105/images/category/manshoe.png"
            myIcon.setImageURI(head);
        }

       myIcon.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getActivity(),PresonActivity.class);
               startActivity(intent);
           }
       });
    }

    @Override
    public void success(HomeBean homeBean) {

        List<HomeBean.DataBean.TuijianBean.ListBeanX> list = homeBean.getData().getTuijian().getList();
        layoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        recyclerViewTuiJian.setLayoutManager(layoutManager);
        apdater = new Myapdater(getActivity(), list);
        recyclerViewTuiJian.setAdapter(apdater);

    }

  /*  @OnClick(R.id.my_icon)
    public void onViewClicked() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        final AlertDialog alertDialog = builder.create();
        View inflate = View.inflate(getActivity(), R.layout.add_image, null);
        TextView tv_select_gallery = inflate.findViewById(R.id.tv_select_camera);
        TextView tv_select_camera = inflate.findViewById(R.id.tv_select_gallery);

        // 在相册中选取
        tv_select_gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                startActivityForResult(intent, 1);
                alertDialog.dismiss();
            }
        });
        // 调用照相机
        tv_select_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(new File(Environment.getExternalStorageDirectory(), "head.jpg")));
                startActivityForResult(intent, 2);
                alertDialog.dismiss();
            }
        });
        alertDialog.setView(inflate);
        alertDialog.show();
    }
*/
    /*@Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    cropPhoto(data.getData());// 裁剪图片
                }

                break;
            case 2:
                if (resultCode == RESULT_OK) {
                    File temp = new File(Environment.getExternalStorageDirectory() + "/head.jpg");
                    cropPhoto(Uri.fromFile(temp));// 裁剪图片
                }

                break;
            case 3:
                if (data != null) {
                    Bundle extras = data.getExtras();
                    head = extras.getParcelable("data");
                    if (head != null) {
                        *//**
                         * 上传服务器代码
                         *//*
                        setPicToView(head);// 保存在SD卡中
                        myIcon.setImageBitmap(head);// 用ImageView显示出来
                    }
                }
                break;
            default:
                break;

        }
        super.onActivityResult(requestCode, resultCode, data);
    }*/

    /*private void cropPhoto(Uri data) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(data, "image/*");
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 3);
    }*/

    /*private void setPicToView(Bitmap mBitmap) {
        String sdStatus = Environment.getExternalStorageState();
        if (!sdStatus.equals(Environment.MEDIA_MOUNTED)) { // 检测sd是否可用
            return;
        }
        FileOutputStream b = null;
        File file = new File(path);
        file.mkdirs();// 创建文件夹
        String fileName = path + "head.jpg";// 图片名字
        try {
            b = new FileOutputStream(fileName);
            mBitmap.compress(Bitmap.CompressFormat.JPEG, 100, b);// 把数据写入文件
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭流
                b.flush();
                b.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/


    @Override
    public void Error(String msg) {

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
