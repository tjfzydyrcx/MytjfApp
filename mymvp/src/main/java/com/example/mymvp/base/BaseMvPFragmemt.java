package com.example.mymvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mymvp.Utils.ReflectUtil;

/**
 * Created by Administrator on 2019-01-19 0019.
 */

public abstract class BaseMvPFragmemt<T extends BasePresenter, M extends BaseModel> extends BaseFragment {

    protected T mPresenter;
    protected M mModel;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter = ReflectUtil.getT(this, 0);
        mModel = ReflectUtil.getT(this, 1);
        mPresenter.onAttach(mModel, this);
        initData();
        loadData();
        initListener();
    }

    protected abstract void loadData();


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDetach();
        }
    }
}
