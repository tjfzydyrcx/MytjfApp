package com.example.mymvp.network.HttpProcessor.processor;


import android.os.Environment;


import com.example.mymvp.Utils.LogUtils;
import com.example.mymvp.network.HttpProcessor.interfaces.ICallBack;
import com.example.mymvp.network.HttpProcessor.interfaces.IhttpProcessor;
import com.example.mymvp.network.HttpProcessor.interfaces.OnDownloadListener;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import com.zhy.http.okhttp.callback.StringCallback;
import com.zhy.http.okhttp.request.RequestCall;

import java.io.File;
import java.io.IOException;
import java.security.cert.CertificateException;
import java.util.Map;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/**
 * Created by Administrator on 2018-08-03 0003.
 *
 */

public class Okhttp3Processor implements IhttpProcessor {
    public static OkHttpClient mOkHttpClient;

    public synchronized OkHttpClient getClient() {
        if (mOkHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            try {
                // 自定义一个信任所有证书的TrustManager，添加SSLSocketFactory的时候要用到
                final X509TrustManager trustAllCert =
                        new X509TrustManager() {
                            @Override
                            public void checkClientTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                            }

                            @Override
                            public void checkServerTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                            }

                            @Override
                            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                                return new java.security.cert.X509Certificate[]{};
                            }
                        };
                final SSLSocketFactory sslSocketFactory = new SSLSocketFactoryCompat(trustAllCert);
                builder.sslSocketFactory(sslSocketFactory, trustAllCert);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            mOkHttpClient = builder.build();
        }
        return mOkHttpClient;
    }

    public Okhttp3Processor() {
        mOkHttpClient = getClient();
        OkHttpUtils.initClient(mOkHttpClient);

    }

    @Override
    public void get(String url, Map<String, String> params, final ICallBack callBack) {
        RequestCall call = OkHttpUtils.get().url(url).params(params).build();
        OkCall(call, callBack);
    }

    @Override
    public void postFile(String url, Map<String, String> params, Map<String, File> fileparams, final ICallBack callBack) {
        RequestCall call = OkHttpUtils.post()
                .url(url)
                .params(params)
                .files("file", fileparams)
                .build();
        OkCall(call, callBack);
    }

    @Override
    public void post(String url, Map<String, String> params, final ICallBack callBack) {
        RequestCall call = OkHttpUtils.
                post().url(url).params(params).build();
        OkCall(call, callBack);
    }

    @Override
    public void DownloadFile(String url, Map<String, File> fileparams, final OnDownloadListener callBack) {
        RequestCall call = OkHttpUtils.post()
                .url(url)
                .files("file", fileparams)
                .build();
        try {
            call.execute(new FileCallBack(isExistDir("files"),"down_text") {
                @Override
                public void onError(Call call, Exception e, int id) {
                    callBack.onDownloadFailed();
                }

                @Override
                public void onResponse(File response, int id) {
                    callBack.onDownloadSuccess();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void OkCall(RequestCall call, final ICallBack callBack) {

        call.execute(new StringCallback() {
            @Override
            public void onError(Call call, Exception e, int id) {
                try {
                    LogUtils.e(e.getLocalizedMessage()+"id=="+e.getCause());

                    callBack.onFailed(e.getMessage());
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }

            @Override
            public void onResponse(String response, int id) {
                try {


                    callBack.onSuccess(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


    }

    /**
     * @param saveDir
     * @return
     * @throws IOException 判断下载目录是否存在
     */
    private String isExistDir(String saveDir) throws IOException {
        // 下载位置
        File downloadFile = new File(Environment.getExternalStorageDirectory(), saveDir);
        if (!downloadFile.mkdirs()) {
            downloadFile.createNewFile();
        }
        String savePath = downloadFile.getAbsolutePath();
        return savePath;
    }


}
