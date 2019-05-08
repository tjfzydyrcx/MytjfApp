package com.example.mytjfapp.TjfMvp.Fragment.Grilmvp;

import com.example.mymvp.base.MvpListener;
import com.example.mymvp.network.HttpProcessor.Http.HttpCallBack;
import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mymvp.network.VolleyUtils.MyListener;
import com.example.mymvp.network.VolleyUtils.RequestManager;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.Utils.LogUtils;

import java.util.HashMap;
import java.util.List;

public class MeiziModelImpl implements MeiziContract.MeiziModel {

    @Override
    public void loadMeizi(final String url, final MvpListener<List<MeiziBean.ResultsBean>> listener) {
      /*  RequestManager.getInstance().sendGet(url, MeiziBean.class, new MyListener<MeiziBean>() {
            @Override
            public void onSuccess(MeiziBean result) {

                LogUtils.e(url+"==zoule=-=="+result.toString());
                listener.onSuccess(result.getResults());
            }

            @Override
            public void onError(String errorMsg) {
                listener.onError(errorMsg);
            }
        });*/

        HttpHelper.obtain().get(url, new HashMap<String, String>(), new HttpCallBack<MeiziBean>() {
            @Override
            public String onSuccess(MeiziBean result) {

                listener.onSuccess(result.getResults());

                return null;
            }

            @Override
            public void onFailed(String string) {
                listener.onError(string);
            }
        });
    }
}
