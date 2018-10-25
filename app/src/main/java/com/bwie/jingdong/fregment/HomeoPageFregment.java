package com.bwie.jingdong.fregment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.jingdong.IView.HomeView;
import com.bwie.jingdong.IView.IMainView;
import com.bwie.jingdong.R;
import com.bwie.jingdong.apdater.FenLetapdater;
import com.bwie.jingdong.apdater.MiaoSaApdater;
import com.bwie.jingdong.apdater.Myapdater;
import com.bwie.jingdong.mvp.model.bean.HomeBean;
import com.bwie.jingdong.mvp.model.bean.UiBean;
import com.bwie.jingdong.mvp.model.utils.MyLoder;
import com.bwie.jingdong.mvp.present.HomePresent;
import com.bwie.jingdong.mvp.present.MainPresent;
import com.bwie.jingdong.mvp.view.activity.FloawActivity;
import com.bwie.jingdong.mvp.view.activity.ShowActivity;
import com.bwie.jingdong.mvp.view.cancvas.NoticeView;
import com.uuzuche.lib_zxing.activity.CaptureActivity;
import com.uuzuche.lib_zxing.activity.CodeUtils;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeoPageFregment extends Fragment implements HomeView, IMainView {

    @BindView(R.id.iv_code)
    ImageView ivCode;
    @BindView(R.id.edt)
    TextView edt;
    @BindView(R.id.iv_news)
    ImageView ivNews;
    @BindView(R.id.banner)
    Banner banner;
    @BindView(R.id.recycler_View)
    RecyclerView recyclerView;
    /*  @BindView(R.id.swipe)
      SwipeRefreshLayout swipe;*/
    Unbinder unbinder;
    @BindView(R.id.recycler_View_grid)
    RecyclerView recyclerViewGrid;
    @BindView(R.id.notice_view)
    NoticeView noticeView;
    @BindView(R.id.but_sousuo)
    Button butSousuo;
    @BindView(R.id.Recycler_View_MiaoSa)
    RecyclerView RecyclerViewMiaoSa;
    private MainPresent present;
    private Myapdater apdater;
    private LinearLayoutManager layoutManager;
    private boolean isFresh;
    private int page = 1;
    private List<String> bannerlist;
    private HomePresent homePresent;

    private final int REQUEST_CODE = 0x1000;
    private MiaoSaApdater miaoapdater;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_homeo_page_fregment, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        init();
        return inflate;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homePresent = new HomePresent(this);
        homePresent.getHome();
        initView();
        //initData();

        //  present.getdatas("手机", page, "0");

        ivCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), CaptureActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        //搜索框
        edt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), FloawActivity.class);
                startActivity(intent);
            }
        });

        butSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = edt.getText().toString();
                Intent intent = new Intent(getActivity(), ShowActivity.class);
                intent.putExtra("s", s);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == REQUEST_CODE) {
            //处理扫描结果（在界面上显示）
            if (null != data) {
                Bundle bundle = data.getExtras();
                if (bundle == null) {
                    return;
                }
                if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_SUCCESS) {
                    String result = bundle.getString(CodeUtils.RESULT_STRING);
                    Toast.makeText(getActivity(), "解析结果:" + result, Toast.LENGTH_LONG).show();
                } else if (bundle.getInt(CodeUtils.RESULT_TYPE) == CodeUtils.RESULT_FAILED) {
                    Toast.makeText(getActivity(), "解析二维码失败", Toast.LENGTH_LONG).show();
                }
            }
        }
    }


    private void init() {
        List<String> notices = new ArrayList<>();
        notices.add("大促销下单拆福袋，亿万新年红包随便拿");
        notices.add("家电五折团，抢十亿无门槛现金红包");
        notices.add("星球大战剃须刀首发送200元代金券");
        noticeView.addNotice(notices);
        noticeView.startFlipping();
    }


    private void initView() {

    }

    /*private void initData() {
        apdater = new Myapdater(getActivity());
        recyclerView.setAdapter(apdater);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (layoutManager.findLastVisibleItemPosition() == apdater.getData().size() - 1) {
                    lodaMore();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });

        swipe.setEnabled(true);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipe.setRefreshing(true);
                refresh();
            }
        });
    }*/

    private void refresh() {
        page = 1;
        isFresh = true;
        present.getdatas("电脑", page, "0");
    }

    private void lodaMore() {
        page++;
        isFresh = false;
        present.getdatas("电脑", page, "0");
    }

    @Override
    public void onSuccess(List<UiBean.DataBean> list) {

    }

    @Override
    public void onErr(String errMsg) {


    }


    private void initBanner(List<HomeBean.DataBean.BannerBean> dataBanner) {

        bannerlist = new ArrayList<>();
        if (dataBanner != null && dataBanner.size() > 0) {
            for (int i = 0; i < dataBanner.size(); i++) {
                String icon = dataBanner.get(i).getIcon();
                bannerlist.add(icon);
            }
            banner.setImages(bannerlist)
                    .setImageLoader(new MyLoder())
                    .isAutoPlay(true)
                    .start();
        }


    }

    @Override
    public void success(HomeBean homeBean) {

        List<HomeBean.DataBean.TuijianBean.ListBeanX> list = homeBean.getData().getTuijian().getList();
        initTuiJian(list);
        Log.i("aaa", homeBean + "");
        List<HomeBean.DataBean.BannerBean> dataBanner = homeBean.getData().getBanner();
        Log.i("ccc", dataBanner.toString() + "");
        initBanner(dataBanner);
        initfenlei(homeBean);
        initMiaoSa(homeBean);

    }

    private void initMiaoSa(HomeBean homeBean) {

        List<HomeBean.DataBean.MiaoshaBean.ListBean> list = homeBean.getData().getMiaosha().getList();
        RecyclerViewMiaoSa.setLayoutManager(new GridLayoutManager(getActivity(), 1, LinearLayoutManager.HORIZONTAL, false));
        miaoapdater = new MiaoSaApdater(getActivity(),list);
        RecyclerViewMiaoSa.setAdapter(miaoapdater);
    }

    private void initTuiJian(List<HomeBean.DataBean.TuijianBean.ListBeanX> list) {
        layoutManager = new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        apdater = new Myapdater(getActivity(), list);
        recyclerView.setAdapter(apdater);
      /*  Log.i("aaa", list + "");
        if (isFresh) {
            apdater.addData(list, true);
            isFresh = false;
            swipe.setRefreshing(false);
        } else {
            apdater.addData(list, false);
        }

        apdater.notifyDataSetChanged();
*/
    }

    private void initfenlei(HomeBean homeBean) {
        List<HomeBean.DataBean.FenleiBean> fenlei = homeBean.getData().getFenlei();
        FenLetapdater fenleiapdater = new FenLetapdater(getActivity(), fenlei);
        recyclerViewGrid.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.HORIZONTAL, false));
        recyclerViewGrid.setAdapter(fenleiapdater);
    }

    @Override
    public void Error(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
