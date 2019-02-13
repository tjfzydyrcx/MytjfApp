package com.example.mytjfapp.Utils;

public class CalcUtils {
    private static long lastClickTime;
    //处理多次连续点击导致打开重复页面  false 是单次点击 true 多次点击

    //防止重复点击 事件间隔，在这里我定义的是1000毫秒
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        LogUtils.e("timss=" + time);
        long timeD = time - lastClickTime;
        LogUtils.e("timeD=" + timeD);
        if (timeD >= 0 && timeD <= 1000) {
            return true;
        } else {
            lastClickTime = time;
            return false;
        }
    }
}
