package com.example.mytjfapp.TjfMvp.Fragment;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.completeimageview.ImageDownloader;

import java.io.File;

public class FileDownLoader implements ImageDownloader {
    @Override
    public File downLoad(String url, Activity activity) {
        File file = null;
        try {
            RequestOptions options = new RequestOptions();
            options.override(Target.SIZE_ORIGINAL);
            file = Glide.with(activity).load(url).downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).get();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return file;
    }
}