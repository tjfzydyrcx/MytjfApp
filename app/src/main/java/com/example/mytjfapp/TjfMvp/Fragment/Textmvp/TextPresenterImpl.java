package com.example.mytjfapp.TjfMvp.Fragment.Textmvp;


import com.example.mymvp.base.MvpListener;
import com.example.mytjfapp.Model.AllBean;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.TjfMvp.Fragment.Grilmvp.MeiziContract;
import com.example.mytjfapp.Utils.LogUtils;

import java.util.List;

/**
 * Created by Administrator on 2019-01-12 0012.
 */

public class TextPresenterImpl extends TextContract.TextPresenter {


    @Override
    public void loadData(String url) {
        final TextContract.TextsView mView = getView();

        if (mView == null) {
            return;
        }
        mView.showLoading();

        mModel.loadText(url, new MvpListener<List<AllBean.ResultsBean>>() {
            @Override
            public void onSuccess(List<AllBean.ResultsBean> result) {

                 mView.hideLoading();
                mView.setData(result);
            }

            @Override
            public void onError(String errorMsg) {
                mView.hideLoading();
                mView.showError();
            }
        });
    }
}
