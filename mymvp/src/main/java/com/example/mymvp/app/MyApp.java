package com.example.mymvp.app;

import android.app.Application;

import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mymvp.network.HttpProcessor.processor.Okhttp3Processor;

public class MyApp extends Application {
    private static MyApp instance;
    
    public static MyApp getInstance() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        HttpHelper.init(new Okhttp3Processor());
    }
}

