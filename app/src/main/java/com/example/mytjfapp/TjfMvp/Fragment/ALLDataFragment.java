package com.example.mytjfapp.TjfMvp.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.example.mytjfapp.Adapter.AllAdapter;
import com.example.mytjfapp.Model.AllBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.TjfMvp.Fragment.Textmvp.TextContract;
import com.example.mytjfapp.TjfMvp.Fragment.Textmvp.TextModelImpl;
import com.example.mytjfapp.TjfMvp.Fragment.Textmvp.TextPresenterImpl;
import com.example.mytjfapp.TjfMvp.WebViewActivity;
import com.example.mytjfapp.TjfMvp.WrapContentLinearLayoutManager;
import com.example.mytjfapp.Utils.CalcUtils;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.StringUrl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-08-14 0014.
 */

public class ALLDataFragment extends BaseMvPFragmemt<TextPresenterImpl, TextModelImpl> implements TextContract.TextsView {
    @BindView(R.id._meiz_recycleView)
    RecyclerView recyclerView;
    AllAdapter adapter;
    List<AllBean.ResultsBean> list = new ArrayList<>();
    int i = 1;
    @BindView(R.id.refresh_srl)
    SwipeRefreshLayout refreshSrl;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_read_fragment, container, false);
    }

    @Override
    protected void loadData() {
        String urls = StringUrl.getAll + i;
        mPresenter.loadData(urls);
    }

    @Override
    public void initData() {
        list.clear();
        init();
        loadData();

    }

    @Override
    protected void initListener() {
        refreshSrl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                list.clear();
                i = 1;
                loadData();
            }
        });

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                if (!CalcUtils.isFastDoubleClick()) {
                    Intent intent = new Intent(getActivity(), WebViewActivity.class);
                    intent.putExtra("url", list.get(position).getUrl());
                    startActivity(intent);
                }

            }
        });
    }


    public void init() {
        recyclerView.setLayoutManager(new WrapContentLinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        adapter = new AllAdapter(getActivity(), R.layout.layout_all_fragment_item, list);
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
                        loadData();
                    }
                }, 500);
            }
        }, recyclerView);
    }

    @Override
    public void showLoading() {
        if (i == 1) {
            refreshSrl.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        refreshSrl.setRefreshing(false);
    }

    @Override
    public void showError() {
        adapter.loadMoreFail();
        refreshSrl.setRefreshing(false);
    }

    @Override
    public void setData(List<AllBean.ResultsBean> beanList) {
        adapter.setBeanList(beanList);
    }
}
