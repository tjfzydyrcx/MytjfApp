package com.example.mytjfapp.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

/**
 * Created by Administrator on 2019-03-14 0014.
 */

public class Zhegaic extends View {
    private int mWidth;
    private int mHeight;
    /**
     * 弧形高度
     */
    private int mArcHeight;
    /**
     * 背景颜色
     */
    private int mBgColor;
    private Paint mPaint;
    private Context mContext;

    public Zhegaic(Context context) {
        super(context);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);


        if (widthMode == MeasureSpec.EXACTLY) {
            mWidth = widthSize;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            mHeight = heightSize;
        }
        setMeasuredDimension(mWidth, mHeight);
    }
 
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        
    }
}
