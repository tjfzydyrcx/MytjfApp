package com.example.mymvp.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2019-01-19 0019.
 */

public abstract class BaseFragment extends Fragment implements BaseView {


    public abstract View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);//加载布局

    public abstract void initData();//加载数据

    protected abstract void initListener();//监听事件

    Unbinder unbind;
    protected View rootView;
    protected Activity mContext;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup inflaters, @Nullable Bundle savedInstanceState) {

        rootView = getFragmentView(inflater, inflaters, savedInstanceState);

        unbind = ButterKnife.bind(this, rootView);
        isViewCreated = true;
        lazyLoad();
        return rootView;
    }


    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        //isVisibleToUser这个boolean值表示:该Fragment的UI 用户是否可见
        if (isVisibleToUser) {
            isUIVisible = true;
            lazyLoad();
            initListener();
        } else {
            isUIVisible = false;
        }
    }

    private void lazyLoad() {
        //这里进行双重标记判断,是因为setUserVisibleHint会多次回调,并且会在onCreateView执行前回调,必须确保onCreateView加载完毕且页面可见,才加载数据
        if (isViewCreated && isUIVisible) {
            initData();
            initListener();
            //数据加载完毕,恢复标记,防止重复加载
            isViewCreated = false;
            isUIVisible = false;


        }
    }


    //Fragment的View加载完毕的标记
    private boolean isViewCreated;

    //Fragment对用户可见的标记
    private boolean isUIVisible;


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);
        if (activity instanceof Activity) {
            this.mContext = (Activity) activity;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mContext = null;
        unbind.unbind();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

}
