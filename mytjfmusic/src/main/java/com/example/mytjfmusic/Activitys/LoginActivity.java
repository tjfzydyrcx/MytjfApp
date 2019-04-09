package com.example.mytjfmusic.Activitys;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.mytjfmusic.R;

/**
 * Created by Administrator on 2019-04-09 0009.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initNavBar(false,"登录页",false);

    }
}
