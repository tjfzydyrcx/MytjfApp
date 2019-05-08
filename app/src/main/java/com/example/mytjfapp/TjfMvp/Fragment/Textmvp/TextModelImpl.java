package com.example.mytjfapp.TjfMvp.Fragment.Textmvp;

import com.example.mymvp.base.MvpListener;
import com.example.mymvp.network.VolleyUtils.MyListener;
import com.example.mymvp.network.VolleyUtils.RequestManager;
import com.example.mytjfapp.Model.AllBean;

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
