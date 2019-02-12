package com.example.mytjfapp.TjfMvp.Fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.mymvp.base.BaseFragment;
import com.example.mymvp.network.HttpProcessor.Http.HttpCallBack;
import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mytjfapp.Adapter.AllAdapter;
import com.example.mytjfapp.Model.AllBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.StringUrl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2018-08-14 0014.
 */

public class AndroidFragment extends BaseFragment  {
    @BindView(R.id._meiz_recycleView)
    RecyclerView recyclerView;
    AllAdapter adapter;
    List<AllBean.ResultsBean> list = new ArrayList<>();
    int i = 1;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_read_fragment, container,false);

    }

    @Override
    public void initData() {
        list.clear();
        init();
        getMeizi();
    }

    @Override
    protected void initListener() {

    }


    public void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new AllAdapter(getActivity(), R.layout.layout_all_fragment_item, list);
        recyclerView.setAdapter(adapter);

        getMeizi();
        adapter.setUpFetchEnable(true);
        adapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                LogUtils.e("onUpFetch");


            }
        });
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
        HttpHelper.obtain().get(StringUrl.getAndroid + i, null, new HttpCallBack<AllBean>() {
            @Override
            public String onSuccess(AllBean result) {
                //   LogUtils.e("dats" + result.toString());
                if (result.getResults().size() > 0) {
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
