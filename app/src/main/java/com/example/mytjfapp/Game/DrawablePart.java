package com.example.mytjfapp.Game;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by Administrator on 2019-02-22 0022.
 */

public abstract class DrawablePart {

    protected Context mContext;
    protected int mGameWidth;
    protected int mGameHeight;
    protected Bitmap bitmap;

    public DrawablePart(Context context, int gameW, int gameH, Bitmap bitmap) {
        this.mContext = context;
        this.mGameHeight = gameH;
        this.mGameWidth = gameW;
        this.bitmap = bitmap;
    }

    public abstract void draw(Canvas canvas);
}
