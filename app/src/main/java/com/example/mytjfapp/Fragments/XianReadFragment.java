package com.example.mytjfapp.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mytjfapp.Adapter.MeiziAdapter;
import com.example.mytjfapp.Adapter.VideoAdapter;
import com.example.mytjfapp.Base.BaseFragment;
import com.example.mytjfapp.HttpProcessor.Http.HttpCallBack;
import com.example.mytjfapp.HttpProcessor.Http.HttpHelper;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.Model.VideoBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.Pupwindowutils;
import com.example.mytjfapp.Utils.ScreenUtils;
import com.example.mytjfapp.Utils.StringUrl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2018-08-14 0014.
 */

public class XianReadFragment extends BaseFragment {

    @BindView(R.id._meiz_recycleView)
    RecyclerView recyclerView;
    JZVideoPlayerStandard jzVideoPlayerStandard;
    VideoAdapter adapter;
    List<VideoBean.ResultsBean> list = new ArrayList<>();
    int i = 1;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_read_fragment, null);
    }

    @Override
    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new VideoAdapter(getActivity(), R.layout.layout_video_item, list);
        recyclerView.setAdapter(adapter);
        getMeizi();
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
        HttpHelper.obtain().get(StringUrl.getVideo + i, null, new HttpCallBack<VideoBean>() {
            @Override
            public void onSuccess(VideoBean result) {
                LogUtils.e("dats" + result.toString());
                if (result.getResults().size() > 0) {
                    list.addAll(result.getResults());
                    adapter.notifyDataSetChanged();
                    adapter.loadMoreComplete();
                } else {
                    adapter.loadMoreEnd();
                }
            }

            @Override
            public void onFailed(String string) {
                LogUtils.e("err" + string.toString());
                adapter.loadMoreFail();
            }
        });
    }
}
