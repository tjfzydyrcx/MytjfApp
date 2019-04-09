package com.example.mytjfmusic.Activitys;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.IntentUtils;
import com.example.mytjfmusic.R;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2019-04-09 0009.
 */

public class WelcomeActivity extends BaseActivity {
    private Timer timer;
    private WelcomeActivity instance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);
        instance = this;
        timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                toMain();
            }
        }, 3 * 1000);
    }

    public void toMain() {
        Intent intent = new Intent(instance, LoginActivity.class);
        startActivity(intent);
//        finish();


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
