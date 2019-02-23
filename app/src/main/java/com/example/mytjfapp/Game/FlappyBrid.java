package com.example.mytjfapp.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.example.mytjfapp.R;
import com.example.mytjfapp.Utils.DensityUtils;


/**
 * Created by Administrator on 2019-02-22 0022.
 */

public class FlappyBrid extends SurfaceView implements Runnable {
    public FlappyBrid(Context context) {
        super(context);
    }

    private Thread mThread;
    private volatile boolean isRunning;

    RectF mDestRest;
    private int mSpeed;

    private Bitmap mBg, mBridBm, mFloorBm;
    private Floor mFloor;
    private Brid mBrid;




    private static  final  int  TOUCH_UN_SIZE=-16;
    private  int mBridUpDis;

    private  static  final  int SIZE_AUTO_DOWN=2;


    private  int  mAutoDownDis;
    private  int  mTmpBridDis;


    public FlappyBrid(Context context, AttributeSet attrs) {
        super(context, attrs);
        SurfaceHolder holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                //创建完成
                // 开启异步线程
                isRunning = true;
                mThread = new Thread(FlappyBrid.this);
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
        mSpeed = DensityUtils.dip2px(getContext(), 2);
        initRes();

    }

    private void initRes() {

        mBg = loadBitmapByResid(R.drawable.bg1);
        mBridBm = loadBitmapByResid(R.drawable.b1);
        mFloorBm = loadBitmapByResid(R.drawable.floor_bg);
    }

    private Bitmap loadBitmapByResid(@DrawableRes int resid) {

        return BitmapFactory.decodeResource(getResources(), resid);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mDestRest = new RectF(0, 0, w, h);

        mFloor = new Floor(getContext(), w, h, mFloorBm);
        mBrid = new Brid(getContext(), w, h, mBridBm);
    }

    @Override
    public void run() {
        while (isRunning) {
            long start = System.currentTimeMillis();


            drawSelf();

            long end = System.currentTimeMillis();

            if (end - start < 50) {
                try {
                    Thread.sleep(50 - (end - start));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void drawSelf() {
        Canvas canvas = null;
        try {
            canvas = getHolder().lockCanvas();

            if (canvas != null) {


                drawBg(canvas);
                logic();
                drawFloor(canvas);


                drawBrid(canvas);


            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            if (canvas != null) {
                getHolder().unlockCanvasAndPost(canvas);
            }

        }


    }

    private void logic() {


        mFloor.setX(mFloor.getX() - mSpeed);
    }

    private void drawBrid(Canvas canvas) {
        mBrid.draw(canvas);
    }

    private void drawFloor(Canvas canvas) {
        mFloor.draw(canvas);
    }

    private void drawBg(Canvas canvas) {
        canvas.drawBitmap(mBg, null, mDestRest, null);

    }


}
