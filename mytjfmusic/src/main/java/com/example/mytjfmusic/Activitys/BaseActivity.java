package com.example.mytjfmusic.Activitys;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytjfmusic.R;

import java.lang.reflect.Proxy;

/**
 * Created by Administrator on 2019-04-09 0009.
 */

public class BaseActivity extends AppCompatActivity {

    protected <T extends View> T fd(@IdRes int id) {

        return findViewById(id);
    }

    private ImageView mIvBack, mIvMe;
    private TextView mTvTitle;

    protected void initNavBar(boolean isShowBack, String title, boolean isShowMe) {
        mIvBack = fd(R.id.Iv_back);
        mIvMe = fd(R.id.Iv_me);
        mTvTitle = fd(R.id.tv_title);

        mTvTitle.setText(title);
        if (isShowBack) {
            mIvBack.setVisibility(View.VISIBLE);
        } else {
            mIvBack.setVisibility(View.GONE);

        }
        if (isShowMe) {
            mIvMe.setVisibility(View.VISIBLE);
        } else {
            mIvMe.setVisibility(View.GONE);
        }

    }

}
