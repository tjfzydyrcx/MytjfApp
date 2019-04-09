package com.example.mytjfapp.TjfMvp.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mymvp.base.BaseFragment;
import com.example.mymvp.base.BaseMvPFragmemt;
import com.example.mymvp.network.HttpProcessor.Http.HttpCallBack;
import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mytjfapp.Adapter.VideoAdapter;
import com.example.mytjfapp.Model.DuanziBean;
import com.example.mytjfapp.Model.VideoBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.TjfMvp.Fragment.duanzimvp.DuanziContract;
import com.example.mytjfapp.TjfMvp.Fragment.duanzimvp.DuanziModelImpl;
import com.example.mytjfapp.TjfMvp.Fragment.duanzimvp.DuanziPresenterImpl;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.StringUrl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018-08-14 0014.
 */

public class DuanziFragment extends BaseMvPFragmemt<DuanziPresenterImpl, DuanziModelImpl> implements DuanziContract.DuanziView {

    @BindView(R.id._meiz_recycleView)
    RecyclerView recyclerView;
    VideoAdapter adapter;
    List<DuanziBean.ResultBean> list = new ArrayList<>();
    int i = 1;


    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_read_fragment, container, false);
    }

    @Override
    protected void loadData() {
        String value = StringUrl.duanzi;
        HashMap<String, String> map = new HashMap<>();
        map.put("page", "1");
        map.put("count", "4");
        map.put("type", "video");
        mPresenter.loadData(value, map);
    }

    @Override
    public void initData() {
        list.clear();
        init();
        loadData();
    }

    @Override
    protected void initListener() {


    }


    public void init() {
        LogUtils.e("zoul;e==");
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new VideoAdapter(getActivity(), R.layout.layout_duanzi_item, list);
        recyclerView.setAdapter(adapter);

        //上拉加载（设置这个监听就表示有上拉加载功能了）
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ++i;
                LogUtils.e("i=" + i);
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 500);
            }
        }, recyclerView);


    }


    @Override
    public void setData(List<DuanziBean.ResultBean> beanList) {
        LogUtils.e("LAI="+beanList.size());
        adapter.loadMoreComplete();
        adapter.setBeanList(beanList);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {
        adapter.loadMoreFail();

    }
}
