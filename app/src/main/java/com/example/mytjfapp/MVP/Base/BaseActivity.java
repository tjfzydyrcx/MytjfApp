package com.example.mytjfapp.MVP.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2019-01-05 0005.
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView{
    protected  P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter= createPresenter();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void onEmpty(Object tag) {

    }

    @Override
    public void onError(Object tag, String errorMsg) {

    }

    @Override
    public Context getContext() {
        return this;
    }

    protected abstract P createPresenter();
}
