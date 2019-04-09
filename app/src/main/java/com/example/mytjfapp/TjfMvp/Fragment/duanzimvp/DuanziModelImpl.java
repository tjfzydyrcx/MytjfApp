package com.example.mytjfapp.TjfMvp.Fragment.duanzimvp;

import com.example.mymvp.base.MvpListener;
import com.example.mymvp.network.HttpProcessor.Http.HttpCallBack;
import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mymvp.network.MyListener;
import com.example.mymvp.network.RequestManager;
import com.example.mytjfapp.Model.DuanziBean;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.StringUrl;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019-03-08 0008.
 */

public class DuanziModelImpl implements DuanziContract.DuanziModel {


    @Override
    public void loadDuanzi(String url, final HashMap<String, String> map, final MvpListener<List<DuanziBean.ResultBean>> listener) {

        HttpHelper.obtain().post(StringUrl.duanzi, map, new HttpCallBack<DuanziBean>() {
            @Override
            public String onSuccess(DuanziBean result) {
                listener.onSuccess(result.getResult());
                return null;
            }

            @Override
            public void onFailed(String string) {
                listener.onError(string);
            }
        });
      /*  RequestManager.getInstance().sendPost(StringUrl.duanzi, DuanziBean.class, map, new MyListener<DuanziBean>() {
            @Override
            public void onSuccess(DuanziBean result) {

//                LogUtils.e("zoule="+result);
                listener.onSuccess(result.getResult());
            }

            @Override
            public void onError(String errorMsg) {
                listener.onError(errorMsg);
            }
        });*/
    }
}
