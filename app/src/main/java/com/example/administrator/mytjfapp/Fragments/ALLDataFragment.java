package com.example.administrator.mytjfapp.Fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.administrator.mytjfapp.Adapter.AllAdapter;
import com.example.administrator.mytjfapp.Adapter.VideoAdapter;
import com.example.administrator.mytjfapp.Base.BaseFragment;
import com.example.administrator.mytjfapp.HttpProcessor.Http.HttpCallBack;
import com.example.administrator.mytjfapp.HttpProcessor.Http.HttpHelper;
import com.example.administrator.mytjfapp.Model.AllBean;
import com.example.administrator.mytjfapp.Model.MeiziBean;
import com.example.administrator.mytjfapp.R;
import com.example.administrator.mytjfapp.Utils.LogUtils;
import com.example.administrator.mytjfapp.Utils.Pupwindowutils;
import com.example.administrator.mytjfapp.Utils.ScreenUtils;
import com.example.administrator.mytjfapp.Utils.StringUrl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-08-14 0014.
 */

public class ALLDataFragment extends BaseFragment
{
    @BindView(R.id._meiz_recycleView)
    RecyclerView recyclerView;
    AllAdapter adapter;
    List<AllBean.ResultsBean> list=new ArrayList<>();
    int i=1;
    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_read_fragment,null);
    }

    @Override
    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AllAdapter(getActivity(), R.layout.layout_all_fragment_item, list);
        recyclerView.setAdapter(adapter);

        getMeizi();
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                AllBean.ResultsBean b = (AllBean.ResultsBean) adapter.getData().get(position);
                LogUtils.e("bs==" + b.getUrl());

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
        HttpHelper.obtain().get(StringUrl.getAll + i, null, new HttpCallBack<AllBean>() {
            @Override
            public void onSuccess(AllBean result) {
                //   LogUtils.e("dats" + result.toString());
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
