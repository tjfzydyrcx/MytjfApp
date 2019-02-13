package com.example.mytjfapp.TjfMvp.Fragment.Textmvp;

import com.example.mymvp.base.MvpListener;
import com.example.mymvp.network.MyListener;
import com.example.mymvp.network.RequestManager;
import com.example.mytjfapp.Model.AllBean;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.TjfMvp.Fragment.Grilmvp.MeiziContract;

import java.util.List;

public class TextModelImpl implements  TextContract. TextsModel {



    @Override
    public void loadText(String url, final MvpListener<List<AllBean.ResultsBean>> listener) {
        RequestManager.getInstance().sendGet(url, AllBean.class, new MyListener<AllBean>() {
            @Override
            public void onSuccess(AllBean result) {
                listener.onSuccess(result.getResults());
            }

            @Override
            public void onError(String errorMsg) {
                listener.onError(errorMsg);
            }
        });
    }
}
