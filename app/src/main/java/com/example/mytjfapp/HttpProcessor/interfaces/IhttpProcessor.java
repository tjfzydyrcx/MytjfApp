package com.example.mytjfapp.HttpProcessor.interfaces;

import java.util.Map;

/**
 * Created by Administrator on 2018-08-03 0003.
 */

public interface IhttpProcessor {

    void get(String url, Map<String, Object> params, ICallBack callBack);

    void post(String url, Map<String, Object> params, ICallBack callBack);
}
