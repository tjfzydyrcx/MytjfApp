package com.example.mymvp.ImgLoadUtils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import com.example.mymvp.Utils.LogUtils;

/**
 * Created by Administrator on 2019-02-23 0023.
 */

public class ImageLoadByGlide implements ImageLoadInterface {

    private static final String TAG = "ImageGlide";

    @Override
    public void display(Context context, final ImageView imageView, final String url, final ImageConfig config, final ImageLoadProcessInterface imageLoadProcessInterface) {

        if (context == null) {

            LogUtils.e(TAG + "-> mContext is null");

            return;
        }

        if (imageView == null) {

            return;

        }


        Context context1 = imageView.getContext();

        if (context1 instanceof Activity) {

            if (((Activity) context1).isFinishing()) {
                return;
            }
        }


        try {
            if ((config == null || config.defaultRes <= 0) && TextUtils.isEmpty(url)) {

                return;

            }
            RequestOptions requestOptions = new RequestOptions();

            if (config != null) {
                if (config.defaultRes > 0) {

                    requestOptions.placeholder(config.defaultRes);


                }

                if (config.failRes > 0) {
                    requestOptions.error(config.failRes);
                }

                if (config.scaleType != null) {


                    switch (config.scaleType) {

                        case CENTER_CROP:

                            requestOptions.centerCrop();

                            break;

                        case FIT_CENTER:
                            requestOptions.fitCenter();
                            break;

                        default:
                            requestOptions.fitCenter();
                            break;

                    }
                } else {

                    requestOptions.fitCenter();
                }

                if (config.radius > 0) {


                    requestOptions.transform(new RoundedCorners(config.radius));


                }


                ImageViewTarget imageViewTarget = new BitmapImageViewTarget(imageView) {

                    @Override
                    public void onLoadStarted(@Nullable Drawable placeholder) {
                        super.onLoadStarted(placeholder);

                        if (imageLoadProcessInterface != null) {
                            imageLoadProcessInterface.onLoadStarted();
                        }
                    }

                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        super.onResourceReady(resource, transition);

                        if (imageLoadProcessInterface != null) {
                            imageLoadProcessInterface.onResourceReady();
                        }
                    }

                    @Override
                    public void onLoadFailed(@Nullable Drawable errorDrawable) {
                        super.onLoadFailed(errorDrawable);

                        if (imageLoadProcessInterface != null) {
                            imageLoadProcessInterface.onLoadFailed();
                        }
                    }

                    @Override
                    public void onLoadCleared(@Nullable Drawable placeholder) {
                        super.onLoadCleared(placeholder);

                        if (imageLoadProcessInterface != null) {
                            imageLoadProcessInterface.onLoadCleared();
                        }
                    }

                    @Override
                    public void getSize(@NonNull SizeReadyCallback cb) {

                        if (config != null && config.width > 0 && config.height > 0) {

                            cb.onSizeReady(config.width, config.height);
                        } else {
                            super.getSize(cb);
                        }
                    }
                };


                if (imageViewTarget != null) {

                    Glide.with(context1).asBitmap().load(url).apply(requestOptions).into(imageViewTarget);
                } else {
                    Glide.with(context1).asBitmap().load(url).apply(requestOptions).into(imageView);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    @Override
    public void resumeLoad(Context context, String url) {
        if (context != null) {

            Glide.with(context).resumeRequests();
        }
    }

    @Override
    public void pauseLoad(Context context, String url) {
        if (context != null ) {

            Glide.with(context).pauseRequests();
        }
    }

    @Override
    public void clearImageView(Context context, ImageView imageView, String url) {
        if (context != null && imageView != null) {

            Glide.with(context).clear(imageView);
        }
    }


}
