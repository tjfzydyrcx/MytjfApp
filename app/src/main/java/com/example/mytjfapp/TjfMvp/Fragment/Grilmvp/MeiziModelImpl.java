package com.example.mytjfapp.TjfMvp.Fragment.Grilmvp;

import com.example.mymvp.base.MvpListener;
import com.example.mymvp.network.MyListener;
import com.example.mymvp.network.RequestManager;
import com.example.mytjfapp.Model.MeiziBean;

import java.util.List;

public class MeiziModelImpl implements MeiziContract.MeiziModel {

    @Override
    public void loadMeizi(String url, final MvpListener<List<MeiziBean.ResultsBean>> listener) {
        RequestManager.getInstance().sendGet(url, MeiziBean.class, new MyListener<MeiziBean>() {
            @Override
            public void onSuccess(MeiziBean result) {
                listener.onSuccess(result.getResults());
            }

            @Override
            public void onError(String errorMsg) {
                listener.onError(errorMsg);
            }
        });
    }
}
