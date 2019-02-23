package com.example.mytjfapp.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Shader;

import java.lang.ref.PhantomReference;

/**
 * Created by Administrator on 2019-02-22 0022.
 */

public class Floor extends DrawablePart {
    private int x, y;

    private static final float RADI0_Y_POS = 4 / 5F;

    private Paint mPaint;

    private BitmapShader shader;

    public Floor(Context context, int gameW, int gameH, Bitmap bitmap) {
        super(context, gameW, gameH, bitmap);

        y = (int) (gameH * RADI0_Y_POS);
        mPaint = new Paint();
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setDither(true);
        shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP);
       /* mPaint.setStyle(Paint.Style.STROKE);

        mPaint.setStrokeWidth(6f);
        mPaint.setColor(Color.GREEN);*/

    }

    @Override
    public void draw(Canvas canvas) {
        canvas.save();
        canvas.translate(x, y);
        mPaint.setShader(shader);
        canvas.drawRect(x, 0, -x + mGameWidth, mGameHeight - y, mPaint);
        canvas.restore();

        mPaint.setShader(null);


    }


    public int getX() {
        return x;

    }

    public void setX(int x) {
        this.x = x;
        if (-x > mGameWidth) {
            this.x = x % mGameWidth;
        }

    }
}
