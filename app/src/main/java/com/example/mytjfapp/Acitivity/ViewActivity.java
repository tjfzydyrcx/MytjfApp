package com.example.mytjfapp.Acitivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.mymvp.Utils.LogUtils;
import com.example.mymvp.base.BaseActivity;
import com.example.mymvp.scaleview.OnValueChangeListener;
import com.example.mymvp.scaleview.VerticalScaleView;
import com.example.mymvp.scaleview1.BaseScaleView;
import com.example.mymvp.scaleview1.VerticalScaleScrollView;
import com.example.mytjfapp.R;
import com.example.mytjfapp.View.DashboardView;
import com.example.mytjfapp.View.DashboradBean;
import com.example.mytjfapp.View.HighlightCR;
import com.example.mytjfapp.View.NewDashboardView;
import com.jdqm.tapelibrary.TapeView;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;

/**
 * Created by Administrator on 2019-03-11 0011.
 */

public class ViewActivity extends BaseActivity {
    @BindView(R.id.view_dashboard)
    DashboardView dashboardView;
    @BindView(R.id.scaleview)
    VerticalScaleScrollView scaleView;

    @BindView(R.id.scaleview1)
    VerticalScaleView scaleView1;
    @BindView(R.id.seekBar)
    MySeekBar seekBar;
    @BindView(R.id.seekBar1)
    SeekBar seekBar1;
    @BindView(R.id.tapeview)
    TapeView tapeView;
    @BindView(R.id.dashboard_view_4)
    DashboardView4 mDashboardView4;
    @BindView(R.id.instrumentView)
    InstrumentView instrumentView;
    @BindView(R.id.text_sub)
    TextView textsub;
    @BindView(R.id.text_add)
    TextView textadd;
    @BindView(R.id.text_number)
    TextView textnumber;

    @Override
    protected int getLayoutId() {
        return R.layout.layout_view_iten;
    }

    private boolean isAnimFinished = true;
    NewDashboardView view1;

    NumberFormat ddf1 = NumberFormat.getNumberInstance();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void initView() {
        view1 = (NewDashboardView) findViewById(R.id.view1);
        List<HighlightCR> highlights = new ArrayList<>();
        highlights.add(new HighlightCR(180, 40, Color.parseColor("#000000")));
        highlights.add(new HighlightCR(220, 50, Color.parseColor("#000000")));
        highlights.add(new HighlightCR(270, 90, Color.parseColor("#000000")));
        DashboradBean dashboradBean = new DashboradBean();
        dashboradBean.setHighlightCRList(highlights);
        dashboradBean.setScaleColor(Color.parseColor("#000000"));
        dashboradBean.setScaleTextColor(Color.parseColor("#000000"));
        dashboradBean.setAllAngle(180);
        dashboradBean.setStartAngle(180);
        dashboradBean.setBigSliceCount(10);
        dashboradBean.setSmallSliceCount(3);
        dashboradBean.setMaxValue(1);
        dashboradBean.setMinValue(0);
        dashboradBean.setIsHalf(true);
        view1.setDashboradBean(dashboradBean);
        view1.setRealTimeValue(0f);

/*

        view1.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //手指在view的坐标
                float curX = event.getX();
                float curY = event.getY();

                float centX = v.getWidth() / 2;
                float centY = v.getHeight();

                float tanY = centY - curY;
                if (tanY < 0) {
                    return true;
                }
                float tanX = centX - curX;
                //弧度
                double aTan = Math.atan2(tanY, tanX);
                double dargree = aTan * 180 / Math.PI;
                LogUtils.e("dargree" + dargree);
                float jindu = (float) (dargree / 180f);
                String yali = ddf1.format(jindu);
//                view1.setRealTimeValue((float) (dargree<0?180-dargree:dargree));
                view1.setRealTimeValue(Float.valueOf(yali));
                return true;
            }
        });
*/

        ddf1.setMaximumFractionDigits(1);
        textsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (view1.getRealTimeValue() >= 0.1) {
                    view1.setRealTimeValue(view1.getRealTimeValue() - 0.1f);
                    String yali = ddf1.format(view1.getRealTimeValue());
                    textnumber.setText(yali + "");
                }
            }
        });
        textadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (view1.getRealTimeValue() < 1) {
                    view1.setRealTimeValue(view1.getRealTimeValue() + 0.1f);
                    String yali = ddf1.format(view1.getRealTimeValue());
                    textnumber.setText(yali + "");
                }

            }
        });
        seekBar1.setMax(10);
        seekBar1.setProgress(0);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                LogUtils.e(progress / 10f + "==zoules=" + progress);
                view1.setRealTimeValue(progress / 10f);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        TempControlView tempControl = findViewById(R.id.temp_control);
        // 设置三格代表温度1度
        tempControl.setAngleRate(3);
        tempControl.setTemp(1, 100, 1);


        dashboardView.setDegree(0);

        scaleView.setOnScrollListener(new BaseScaleView.OnScrollListener() {
            @Override
            public void onScaleScroll(int scale) {
                LogUtils.e("kehu=" + scale);
            }
        });
        scaleView1.setRange(0, 30);
        scaleView1.setOnValueChangeListener(new OnValueChangeListener() {
            @Override
            public void onValueChanged(float value) {
                LogUtils.e("kehu111=" + value);
            }
        });
        tapeView.setValue(0, 0, 3, 0.1f, 10);
        tapeView.setOnValueChangeListener(new TapeView.OnValueChangeListener() {
            @Override
            public void onChange(float value) {
                LogUtils.e("kehu2222=" + value);

            }
        });
        seekBar.setProgress(0);
        seekBar.getThumb().setColorFilter(getResources().getColor(R.color.orange), PorterDuff.Mode.SRC_ATOP);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                LogUtils.e(progress + "==进度值");
                instrumentView.setProgress(progress);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        mDashboardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofInt(mDashboardView4, "mRealTimeValue",
                        mDashboardView4.getVelocity(), new Random().nextInt(180));
                animator.setDuration(1500).setInterpolator(new LinearInterpolator());
                animator.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        isAnimFinished = false;
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        isAnimFinished = true;
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        isAnimFinished = true;
                    }
                });
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int value = (int) animation.getAnimatedValue();
                        mDashboardView4.setVelocity(value);
                    }
                });
                animator.start();
            }
        });
    }
}
