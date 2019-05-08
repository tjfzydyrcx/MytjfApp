package com.example.mymvp.network.VolleyUtils;

/**
 * Created by Administrator on 2019-01-06 0006.
 */

public interface MyListener<T> {

    void onSuccess(T result);
    void onError(String errorMsg);
}
