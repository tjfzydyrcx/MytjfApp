package com.example.mytjfapp;

import android.app.Application;

import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mymvp.network.HttpProcessor.processor.Okhttp3Processor;


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
