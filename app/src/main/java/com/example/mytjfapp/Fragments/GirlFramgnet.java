package com.example.mytjfapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mymvp.network.HttpProcessor.Http.HttpCallBack;
import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mytjfapp.Adapter.MeiziAdapter;
import com.example.mytjfapp.Base.BaseFragment;

import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.Pupwindowutils;
import com.example.mytjfapp.Utils.ScreenUtils;
import com.example.mytjfapp.Utils.StringUrl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018-08-09 0009.
 */

public class GirlFramgnet extends BaseFragment {
    @BindView(R.id._meiz_recycleView)
    RecyclerView recyclerView;

    List<MeiziBean.ResultsBean> list = new ArrayList<>();
    List<MeiziBean> listmeiz = new ArrayList<>();
    int i = 1;
    MeiziAdapter adapter;
    Window window;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_read_fragment, null);
    }

    private long mStartTime = 0; // 定义一个初始判断时间变量

    @Override
    public void init() {
        window = getActivity().getWindow();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MeiziAdapter(getActivity(), R.layout.layout, list);
        recyclerView.setAdapter(adapter);
//        adapter.openLoadAnimation();
        getMeizi();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                long interval = System.currentTimeMillis() - mStartTime;     // 两次点击时间间隔
                if (interval >= 500) {
                    mStartTime = System.currentTimeMillis();
                    ScreenUtils.hide_statuslan(window);
                    MeiziBean.ResultsBean b = (MeiziBean.ResultsBean) adapter.getData().get(position);
                    LogUtils.e("bs==" + b.getUrl());
                    List<MeiziBean.ResultsBean> mlistb;
                    for (int i = 0; i < listmeiz.size(); i++) {
                        mlistb = listmeiz.get(i).getResults();
                        for (int j = 0; j < mlistb.size(); j++) {
                            if (mlistb.get(j).getUrl().equals(b.getUrl())) {
                                Pupwindowutils mPupwindowutils =
                                        new Pupwindowutils(window, getActivity(), listmeiz.get(i).getResults());
                                mPupwindowutils.popuwindow_image(view, j, true);
                            }
                        }
                    }
                }
            }
        });
        //上拉加载（设置这个监听就表示有上拉加载功能了）
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                ++i;
                LogUtils.e("i=" + i);
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        getMeizi();
                    }
                }, 500);
            }
        }, recyclerView);


    }

    public void getMeizi() {
        HttpHelper.obtain().get(StringUrl.getMeiziUrl + i, null, new HttpCallBack<MeiziBean>() {
            @Override
            public String onSuccess(MeiziBean result) {
                LogUtils.e("dats" + result.toString());
                if (result.getResults().size() > 0) {
                    listmeiz.add(result);
                    list.addAll(result.getResults());
                    adapter.notifyDataSetChanged();
                    adapter.loadMoreComplete();
                } else {
                    adapter.loadMoreEnd();
                }

                return null;
            }

            @Override
            public void onFailed(String string) {
                LogUtils.e("err" + string.toString());
                adapter.loadMoreFail();
            }
        });
    }
}
