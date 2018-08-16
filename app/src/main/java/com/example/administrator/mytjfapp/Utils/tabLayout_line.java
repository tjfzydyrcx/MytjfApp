package com.example.administrator.mytjfapp.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.design.widget.TabLayout;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;

/**
 * Created by Administrator on 2018-08-09 0009.
 */

public class tabLayout_line {


    /**
     * 通过反射动态改变tablay下划线长度
     *
     * @param tabs
     * @param leftDip
     * @param rightDip
     */
    public static void setIndicator(TabLayout tabs, int leftDip, int rightDip) {
        Class<?> tabLayout = tabs.getClass();
        Field tabStrip = null;
        try {//mTabStrip
            tabStrip = tabLayout.getDeclaredField("mTabStrip");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        tabStrip.setAccessible(true);
        LinearLayout llTab = null;
        try {
            llTab = (LinearLayout) tabStrip.get(tabs);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        int left = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, leftDip, Resources.getSystem().getDisplayMetrics());
        int right = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, rightDip, Resources.getSystem().getDisplayMetrics());

        for (int i = 0; i < llTab.getChildCount(); i++) {
            View child = llTab.getChildAt(i);
            child.setPadding(0, 0, 0, 0);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            params.leftMargin = left;
            params.rightMargin = right;
            child.setLayoutParams(params);
            child.invalidate();
        }
    }

    public static void setTabWidth(TabLayout tabLayout, Context context) {
        //拿到SlidingTabStrip的布局
        LinearLayout mTabStrip = (LinearLayout) tabLayout.getChildAt(0);
        //遍历SlidingTabStrip的所有TabView子view
        for (int i = 0; i < mTabStrip.getChildCount(); i++) {
            View tabView = mTabStrip.getChildAt(i);
            //通过反射拿到TabView的的mTextView
            Field mTextViewField = null;
            try {
                mTextViewField = tabView.getClass().getDeclaredField("mTextView");
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            mTextViewField.setAccessible(true);
            //拿到TextView的宽度
            TextView mTextView = null;
            try {
                mTextView = (TextView) mTextViewField.get(tabView);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            int txWidth = mTextView.getMeasuredWidth();
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
            //给TabView设置宽度
            params.width = txWidth;
            //还可以使用tabView.setMinimumWidth(txWidth);给TabView设置最小宽度为textView的宽度

            //给TabView设置leftMargin和rightMargin
            params.leftMargin = dip2px(context, 10);
            params.rightMargin = dip2px(context, 10);
            tabView.setLayoutParams(params);
            //触发绘制
            tabView.invalidate();
        }
    }

    public static int dip2px(Context context, float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}
