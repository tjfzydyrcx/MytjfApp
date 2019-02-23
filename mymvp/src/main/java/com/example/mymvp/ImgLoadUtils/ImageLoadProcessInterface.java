package com.example.mymvp.ImgLoadUtils;

/**
 *
 * 图片的加载回到过程
 * Created by Administrator on 2019-02-23 0023.
 */

public interface ImageLoadProcessInterface {

    /**
     * 开始加载
     */
    void onLoadStarted();

    /**
     * 资源准备妥当
     */
    void onResourceReady();

    /**
     * 资源已经释放
     */
    void onLoadCleared();

    /**
     * 资源加载失败
     */
    void onLoadFailed();



}
