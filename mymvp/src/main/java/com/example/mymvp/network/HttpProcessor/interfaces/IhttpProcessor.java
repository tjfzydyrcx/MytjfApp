package com.example.mymvp.network.HttpProcessor.interfaces;

import java.io.File;
import java.util.Map;

/**
 * Created by Administrator on 2018-08-03 0003.
 */

public interface IhttpProcessor {

    void get(String url, Map<String, String> params, ICallBack callBack);
    void postFile(String url, Map<String, String> params, Map<String, File> fileparams, ICallBack callBack);
    void post(String url, Map<String, String> params, ICallBack callBack);
    void DownloadFile(String url, Map<String, File> fileparams, OnDownloadListener callBack);
}
