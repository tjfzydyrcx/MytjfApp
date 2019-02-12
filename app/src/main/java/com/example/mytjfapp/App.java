package com.example.mytjfapp;

import android.app.Application;



/**
 * Created by Administrator on 2018-08-09 0009.
 */

public class App extends Application {
    App instance;
    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;

    }

}
