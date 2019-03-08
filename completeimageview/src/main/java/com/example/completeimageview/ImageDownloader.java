package com.example.completeimageview;

import android.app.Activity;

import java.io.File;

/**
 * Created by qiaoyuang on 2017/4/26.
 * 下载图片的抽象接口  通过该接口，实现图片的下载，方式自选
 */

public interface ImageDownloader {
    File downLoad(String url, Activity activity);
}