package com.example.mywenda.Presenter;

import android.content.Context;

import com.example.mymvp.base.BasePresenter;
import com.example.mywenda.bean.Questioninfo;
import com.example.mywenda.view.ITestView;

import java.util.List;

/**
 * Created by Administrator on 2019-04-27 0027.
 */

public class TestPresenter {
    private ITestView iTestViewL;

    private Context context;

    private List<Questioninfo> mList;

    public TestPresenter(ITestView iTestView) {
        this.context = (Context) iTestView;
        this.iTestViewL = iTestView;

    }

    public void getData() {
        iTestViewL.updateUI(mList);

    }


}
