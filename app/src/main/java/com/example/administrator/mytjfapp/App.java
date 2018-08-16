package com.example.administrator.mytjfapp;

import android.app.Application;

import com.example.administrator.mytjfapp.HttpProcessor.Http.HttpHelper;
import com.example.administrator.mytjfapp.HttpProcessor.processor.Okhttp3Processor;

/**
 * Created by Administrator on 2018-08-09 0009.
 */

public class App extends Application {
    App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        HttpHelper.init(new Okhttp3Processor());
    }

}
