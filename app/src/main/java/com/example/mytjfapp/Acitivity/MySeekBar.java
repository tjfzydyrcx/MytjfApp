package com.example.mytjfapp.Acitivity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.SeekBar;

import com.example.mytjfapp.R;
import com.example.mytjfapp.Utils.LogUtils;
import com.tencent.mm.sdk.platformtools.Log;

public class MySeekBar extends SeekBar {

    public MySeekBar(Context context) {
        super(context);
    }

    public MySeekBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MySeekBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    String[] str = {"下", "中", "上"};

    @Override
    protected void onDraw(Canvas canvas) {

    /*    Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.black));
        paint.setStrokeWidth(4);
//        canvas.rotate(90);
        //绘制中间的线条
        float centerY = getHeight() / 2;
        canvas.drawLine(0, centerY, getWidth(), centerY, paint);

        //绘制刻度
        float startX = 0;
        for (int i = 0; i < 5; i++) {

            startX = i * (getWidth() / 4);
            canvas.drawLine(startX, centerY - 10, startX, centerY, paint);

        }*/
        canvas.rotate(-90);//反转90度，将水平SeekBar竖起来
        canvas.translate(-getMeasuredHeight() - getPaddingStart(), 0);
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(R.color.black));
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);
        //绘制中间的线条
        float centerY = getHeight() / 2;
        canvas.drawLine(0, centerY, getWidth(), centerY, paint);
       /*float centerY = getMeasuredWidth() / 2;
        canvas.drawLine(centerY, centerY, getMeasuredHeight(), centerY, paint);*/
        LogUtils.e(getMeasuredWidth() + "==宽度");

        for (int i = 0; i < 3; i++) {
            float startX = 0;
            startX = startX + i * ((getMeasuredWidth()  - getPaddingEnd() - getPaddingStart()) / 2 + 2);
            if (i == 0) {
                startX = startX + 2;
                canvas.drawLine(startX, centerY - 50, startX, centerY, paint);
                canvas.drawLine(startX, centerY + 50, startX, centerY, paint);
            } else if (i == 2) {
                startX = startX - 50;
            }
            canvas.drawLine(startX, centerY - 50, startX, centerY - 10, paint);
            canvas.drawLine(startX, centerY + 50, startX, centerY + 10, paint);
        }

        Paint textPaint = new Paint();
        //水平居中
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        //字体的相关设置
        textPaint.setTextSize(24.0f);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setColor(getResources().getColor(R.color.black));
        for (int j = 0; j < str.length; j++) {
            float startX = 0;
            startX = startX + j * ((getMeasuredWidth() - getPaddingEnd() - getPaddingStart()) / 2);
            if (j == 0) {
                startX = startX + 10;
            } else if (j == 2) {
                startX = startX - 30;
            }
            drawText(canvas, str[j], startX, centerY - 64, textPaint, 90);
        }
        super.onDraw(canvas);
    }

    void drawText(Canvas canvas, String text, float x, float y, Paint paint, float angle) {
        if (angle != 0) {
            canvas.rotate(angle, x, y);
        }
        canvas.drawText(text, x, y, paint);
        if (angle != 0) {
            canvas.rotate(-angle, x, y);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(h, w, oldh, oldw);
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
    }


    @Override
    public synchronized void setProgress(int progress) {
        super.setProgress(progress);
        onSizeChanged(getWidth(), getHeight(), 0, 0);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!isEnabled()) {
            return false;
        }
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
            case MotionEvent.ACTION_UP:
                setProgress(getMax()
                        - (int) (getMax() * event.getY() / getHeight()));
                onSizeChanged(getWidth(), getHeight(), 0, 0);
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }

}
