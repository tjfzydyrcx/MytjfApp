package com.example.mytjfapp.TjfMvp.Fragment.duanzimvp;

import android.view.View;

import com.example.mymvp.base.MvpListener;
import com.example.mytjfapp.Model.DuanziBean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019-03-08 0008.
 */

public class DuanziPresenterImpl extends DuanziContract.DuanziPresenter {


    @Override
    public void loadData(String url, HashMap<String,String> map) {
        final DuanziContract.DuanziView duanziView = getView();

        if (duanziView == null) {
            return;
        }
        duanziView.showLoading();

        mModel.loadDuanzi(url,map, new MvpListener<List<DuanziBean.ResultBean>>() {
            @Override
            public void onSuccess(List<DuanziBean.ResultBean> result) {
                duanziView.hideLoading();
                duanziView.setData(result);

            }

            @Override
            public void onError(String errorMsg) {
                duanziView.hideLoading();
              duanziView.showError();
            }
        });

    }
}
