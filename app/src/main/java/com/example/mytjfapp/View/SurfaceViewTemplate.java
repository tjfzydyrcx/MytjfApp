package com.example.mytjfapp.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Administrator on 2019-02-22 0022.
 */

public class SurfaceViewTemplate extends SurfaceView implements Runnable {
    public SurfaceViewTemplate(Context context) {
        super(context);
    }

    private Thread mThread;
    private volatile boolean isRunning;
    private Paint mPaint;

    private int mMinRadius, mMaxRadius, mRadius, mFlag;


    public SurfaceViewTemplate(Context context, AttributeSet attrs) {
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //创建完成
                // 开启异步线程
                isRunning=true;
                mThread = new Thread(SurfaceViewTemplate.this);
                mThread.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {
                isRunning = false;
            }
        });
        setFocusable(true);
        setFocusableInTouchMode(true);
        setKeepScreenOn(true);

        initPaint();

    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.STROKE);

        mPaint.setStrokeWidth(6f);
        mPaint.setColor(Color.GREEN);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mMaxRadius = Math.min(w, h) / 2 - 20;
        mRadius = mMinRadius = 30;
    }

    @Override
    public void run() {
        while (isRunning) {
            drawSelf();
        }

    }

    private void drawSelf() {
        Canvas canvas = null;
        try {
            canvas = getHolder().lockCanvas();

            if (canvas != null) {
//                drawCircle(canvas);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (canvas != null) {
                getHolder().unlockCanvasAndPost(canvas);
            }

        }


    }

    private void drawCircle(Canvas canvas) {

        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, mRadius, mPaint);
        if (mRadius >= mMaxRadius) {
            mFlag = -1;
        } else if (mRadius <= mMinRadius) {
            mFlag = 1;
        }
        mRadius += mFlag * 2;

    }
}
