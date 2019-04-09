package com.example.mymvp.scaleview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2019-03-12 0012.
 */

public class VerticalScaleViews extends View {

    private Paint paint;
    private int height=200, width=60;//view高宽
    private int ruleWidth;//刻度尺宽

    private int max;//最大刻度
    private int min;//最小刻度
    Rect rect;
    public VerticalScaleViews(Context context) {
        super(context);
        init();
    }

    public VerticalScaleViews(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public VerticalScaleViews(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        //初始化画笔
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
