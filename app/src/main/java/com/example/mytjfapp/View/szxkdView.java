package com.example.mytjfapp.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mytjfapp.R;

/**
 * Created by Administrator on 2019-05-03 0003.
 */

public class szxkdView extends View {

    String[] str = {"下", "中", "上"};
    private int height = -1;
    private int width = -1;

    public szxkdView(Context context) {
        super(context);
        init() ;
    }

    public szxkdView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init() ;
    }

    public szxkdView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init() ;
    }
    Paint textPaint  ;
    Paint paint;
    public void init() {
        paint = new Paint();
        textPaint = new Paint();
    }

    @Override
    protected synchronized void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        width = View.MeasureSpec.getSize(widthMeasureSpec);
        ;
        height = View.MeasureSpec.getSize(heightMeasureSpec);

        this.setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.rotate(-90);
        canvas.translate(-height, 0);
        //绘制中间的线条
        float centerY = width / 2;


        paint.setColor(getResources().getColor(R.color.black));
        paint.setStrokeWidth(4);
        paint.setAntiAlias(true);
        for (int i = 0; i < 3; i++) {
            float startX = 0;
            startX = startX + i * (height / 2 + 2);
            if (i == 0 || i == 1) {
                startX = startX + 2;

            } else if (i == 2) {
                startX = startX - 20;
            }
            canvas.drawLine(startX, centerY - 20, startX, centerY, paint);
            canvas.drawLine(startX, centerY + 20, startX, centerY, paint);
        }



        //水平居中
        textPaint.setTextAlign(Paint.Align.CENTER);
        textPaint.setAntiAlias(true);
        //字体的相关设置
        textPaint.setTextSize(24.0f);
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        textPaint.setColor(getResources().getColor(R.color.black));
        for (int j = 0; j < str.length; j++) {
            float startX = 0;
            startX = startX + j * (height / 2);
            if (j == 0) {
                startX = startX + 10;
            } else if (j == 1) {
                startX = startX-4;
            } else if (j == 2) {
                startX = startX - 24;
            }

            drawText(canvas, str[j], startX, centerY - 34, textPaint, 90);
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
}
