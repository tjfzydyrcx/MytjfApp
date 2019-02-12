package com.example.mytjfapp.TjfMvp.Fragment;


import com.example.mymvp.base.MvpListener;
import com.example.mytjfapp.Model.MeiziBean;

import java.util.List;

/**
 * Created by Administrator on 2019-01-12 0012.
 */

public class DailyPresenterImpl extends MeiziContract.MeiziPresenter{


    @Override
    protected void loadData(String url) {
        final MeiziContract.MeizView mView = getView();

        if (mView == null) {
            return;
        }
        mView.showLoading();

        mModel.loadMeizi(url, new MvpListener<List<MeiziBean.ResultsBean>>() {
            @Override
            public void onSuccess(List<MeiziBean.ResultsBean> result) {
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
