package com.example.mymvp.network.HttpProcessor.Http;


import com.example.mymvp.Utils.LogUtils;
import com.example.mymvp.network.HttpProcessor.interfaces.ICallBack;
import com.example.mymvp.network.HttpProcessor.interfaces.IhttpProcessor;
import com.example.mymvp.network.HttpProcessor.interfaces.OnDownloadListener;

import java.io.File;
import java.util.HashMap;
import java.util.Map;



/**
 * Created by Administrator on 2018-08-03 0003.
 */

public class HttpHelper implements IhttpProcessor {

    private static IhttpProcessor mIhttpProcessor;
    private static HttpHelper _instance;
    private Map<String, Object> mParams;

    private HttpHelper() {
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
        LogUtils.e("ok=="+"好了");
    }


    @Override
    public void get(String url, Map<String, String> params, ICallBack callBack) {
        mIhttpProcessor.get(url, params, callBack);
    }

    @Override
    public void postFile(String url, Map<String, String> params, Map<String, File> fileparams, ICallBack callBack) {
        mIhttpProcessor.postFile(url, params, fileparams, callBack);
    }

    @Override
    public void post(String url, Map<String, String> params, ICallBack callBack) {
        mIhttpProcessor.post(url, params, callBack);
    }

    @Override
    public void DownloadFile(String url, Map<String, File> fileparams, OnDownloadListener callBack) {
        mIhttpProcessor.DownloadFile(url,fileparams, callBack);
    }


}
