package com.example.administrator.mytjfapp.HttpProcessor.Http;



import com.example.administrator.mytjfapp.HttpProcessor.interfaces.ICallBack;
import com.example.administrator.mytjfapp.HttpProcessor.interfaces.IhttpProcessor;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018-08-03 0003.
 */

public class HttpHelper implements IhttpProcessor {

    private static IhttpProcessor mIhttpProcessor;
    private static HttpHelper _instance;
    private Map<String,Object> mParams;
    private HttpHelper(){
        mParams = new HashMap<>();
    }

    public static HttpHelper obtain() {
        if (_instance == null) {
            synchronized (HttpHelper.class) {
                if (_instance == null) {
                    _instance = new HttpHelper();
                }
            }
        }
        return _instance;
    }

    public static void init(IhttpProcessor httpProcessor) {
        mIhttpProcessor = httpProcessor;
    }


    @Override
    public void get(String url, Map<String, Object> params, ICallBack callBack) {
        mIhttpProcessor.get(url, params, callBack);
    }

    @Override
    public void post(String url, Map<String, Object> params, ICallBack callBack) {
        mIhttpProcessor.post(url, params, callBack);
    }


}
