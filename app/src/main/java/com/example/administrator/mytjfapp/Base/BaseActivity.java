package com.example.administrator.mytjfapp.Base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gyf.barlibrary.ImmersionBar;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-08-09 0009.
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected Context context;
    protected BaseActivity activity;
    protected String className = getClass().getSimpleName();

    protected abstract int getLayoutViewID(); //Layout 界面id

    protected abstract void initView(); //界面配置參數,必須在setContentView之前

    protected abstract void doCreateBusiness();//和Create有关的业务方法

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        setContentView(getContentView());
        context = getApplicationContext();
        ImmersionBar.with(this).init();
        ButterKnife.bind(this);
//        AIO.getInstance().addActivityList(this); //AIO是我封装的Application的单例，管理Activity和Service使用的
//        bindListener();
        doCreateBusiness();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public int getContentView() {
        return getLayoutViewID();
    }
}
