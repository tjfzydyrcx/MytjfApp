package com.example.mytjfapp.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.mytjfapp.Utils.DensityUtils;

/**
 * Created by Administrator on 2019-02-22 0022.
 */

public class WhyPeiqi extends View {
    Context context;

    public WhyPeiqi(Context context) {
        super(context);
    }

    public WhyPeiqi(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WhyPeiqi(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private RectF rect;
    private Paint paintPink;
    private Paint paintRed;


    public void init() {

        rect = new RectF();
        //初始化矩形，各个部位的父容器，如鼻子是在矩形内部椭圆
        paintPink = new Paint();
        paintPink.setColor(Color.rgb(255, 155, 192));

        paintPink.setStyle(Paint.Style.STROKE);

        paintRed.setStrokeWidth(3f);

        paintRed.setAntiAlias(true);
        paintPink.setStrokeWidth(3f);

        paintPink.setAntiAlias(true);

        //初始化矩形，各个部位的父容器，如鼻子是在矩形内部椭圆
        paintRed = new Paint();
        paintRed.setColor(Color.rgb(255, 155, 192));

        paintRed.setStyle(Paint.Style.STROKE);

    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        rect.set(DensityUtils.dip2px(getContext(), 200), DensityUtils.dip2px(getContext(), 101), DensityUtils.dip2px(getContext(), 250), DensityUtils.dip2px(getContext(), 160));
        canvas.rotate(-15, DensityUtils.dip2px(getContext(), 225), DensityUtils.dip2px(getContext(), 150));


    }
}
