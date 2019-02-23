package com.example.mytjfapp.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.mytjfapp.Utils.DensityUtils;

/**
 * Created by Administrator on 2019-02-22 0022.
 */

public class Brid extends DrawablePart {
    private int x, y;

    private static final float RADI0_Y_POS = 1 / 2F;


    private static final int WIDTH_BRID = 30;

    private int mWidth, mHeight;

    private RectF rectF = new RectF();


    public Brid(Context context, int gameW, int gameH, Bitmap bitmap) {
        super(context, gameW, gameH, bitmap);

        y = (int) (gameH * RADI0_Y_POS);

        this.mWidth = DensityUtils.dip2px(context, WIDTH_BRID);
        this.mHeight = (int) (mWidth * 1.0f / bitmap.getWidth() * bitmap.getHeight());
        x = gameW / 2 - mWidth / 2;

    }

    @Override
    public void draw(Canvas canvas) {

        rectF.set(x, y, x + mWidth, y + mHeight);
        canvas.drawBitmap(bitmap, null, rectF, null);

    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
