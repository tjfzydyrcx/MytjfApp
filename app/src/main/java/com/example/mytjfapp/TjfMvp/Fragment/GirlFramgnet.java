package com.example.mytjfapp.TjfMvp.Fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.completeimageview.CompleteImageView;
import com.example.mymvp.Utils.LogUtils;
import com.example.mymvp.base.BaseMvPFragmemt;
import com.example.mytjfapp.Adapter.MeiziAdapter;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.R;
import com.example.mytjfapp.TjfMvp.Fragment.Grilmvp.MeiziContract;
import com.example.mytjfapp.TjfMvp.Fragment.Grilmvp.MeiziModelImpl;
import com.example.mytjfapp.TjfMvp.Fragment.Grilmvp.MeiziPresenterImpl;
import com.example.mytjfapp.Utils.Pupwindowutils;
import com.example.mytjfapp.Utils.ScreenUtils;
import com.example.mytjfapp.Utils.StringUrl;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-08-09 0009.
 */

public class GirlFramgnet extends BaseMvPFragmemt<MeiziPresenterImpl, MeiziModelImpl> implements MeiziContract.MeizView {
    @BindView(R.id._meiz_recycleView)
    RecyclerView recyclerView;
    List<String> list1 = new ArrayList<>();

    List<MeiziBean.ResultsBean> list = new ArrayList<>();
    List<MeiziBean> listmeiz = new ArrayList<>();
    int i = 1;
    MeiziAdapter adapter;
    Window window;


    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.layout_meiziaty, container, false);
    }

    private long mStartTime = 0; // 定义一个初始判断时间变量

    CompleteImageView completeImageView;

    @Override
    public void initData() {
        completeImageView = new CompleteImageView(getActivity(), new FileDownLoader());
        list.clear();
        window = getActivity().getWindow();
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        adapter = new MeiziAdapter(getActivity(), R.layout.layout, list);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                long interval = System.currentTimeMillis() - mStartTime;     // 两次点击时间间隔
                if (interval >= 500) {
                    mStartTime = System.currentTimeMillis();
                    ScreenUtils.hide_statuslan(window);
                    MeiziBean.ResultsBean b = (MeiziBean.ResultsBean) adapter.getData().get(position);
                    list1 = new ArrayList<>();
                    for (int i = 0; i < list.size(); i++) {
//                        list1.add(list.get(i).getUrl());
                        if (list.get(i).getUrl().equals(b.getUrl())) {

                            Pupwindowutils mPupwindowutils =
                                    new Pupwindowutils(window, getActivity(), list);
                            mPupwindowutils.popuwindow_image(view, i, true);

                        }

                    }


                   /* completeImageView.setUrls(list1,position);
                    completeImageView.create();*/

                }
            }
        });
        //上拉加载（设置这个监听就表示有上拉加载功能了）

        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        ++i;
                        LogUtils.e("i=" + i);
                        loadData();
                    }
                }, 3000);


            }
        }, recyclerView);


    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void loadData() {
        String value = StringUrl.getMeiziUrl + i;
        LogUtils.e("luanma" + value);
        mPresenter.loadData(value);
    }


    @Override
    public void setData(List<MeiziBean.ResultsBean> beanList) {
        adapter.loadMoreComplete();
        adapter.setBeanList(beanList);
        LogUtils.e("数据===" + beanList.size());
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
