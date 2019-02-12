package com.example.mytjfapp.MVP.Base;

import android.content.Context;

import java.util.Objects;

/**
 * Created by Administrator on 2018-12-29 0029.
 */

public interface IBaseView {
    /**
     * @author 小飞
     * @create 2018-12-29 11:56
     * @Describe 显示加载框
     */
    void showLoading();

    /**
     * @author 小飞
     * @create 2018-12-29 11:56
     * @Describe 关闭加载框
     */
    void dismissLoading();

    /**
     * @param tag TAG
     * @author 小飞
     * @create 2018-12-29 11:56
     * @Describe 空数据
     */
    void onEmpty(Object tag);

    /**
     * @param tag      TAG
     * @param errorMsg 错误信息
     * @author 小飞
     * @create 2018-12-29 11:56
     * @Describe 错误数据
     */
    void onError(Object tag, String errorMsg);

    /**
     * @author 小飞
     * @create 2018-12-29 11:56
     * @Describe 上下文
     */
    Context getContext();
}
