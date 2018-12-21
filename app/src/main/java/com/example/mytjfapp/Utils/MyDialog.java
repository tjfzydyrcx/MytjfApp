package com.example.mytjfapp.Utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.mytjfapp.R;


public class MyDialog extends Dialog {

    private Context context = null;
    private static MyDialog myDialog;

    public MyDialog(Context context) {
        super(context);
        this.context = context;
    }

    public MyDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    public static MyDialog createDialog1(Context context) {
        ProgressBar progressBar;
        View view = LayoutInflater.from(context).inflate(R.layout.progress_dialog2, null);
        progressBar = (ProgressBar) view.findViewById(R.id.act_detail_progress);
        if (android.os.Build.VERSION.SDK_INT > 22) {//android 6.0替换clip的加载动画
            final Drawable drawable = context.getResources().getDrawable(R.drawable.pro_ani_list1);
            progressBar.setIndeterminateDrawable(drawable);
        }
        myDialog = new MyDialog(context, R.style.CustomProgressDialog1);
        myDialog.setCanceledOnTouchOutside(false);
        myDialog.setContentView(view);
        myDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return myDialog;
    }

    public static MyDialog createDialog1start(Context context) {
        ProgressBar progressBar;
        View view = LayoutInflater.from(context).inflate(R.layout.progress_dialog2, null);
        progressBar = (ProgressBar) view.findViewById(R.id.act_detail_progress);
        if (android.os.Build.VERSION.SDK_INT > 22) {//android 6.0替换clip的加载动画
            final Drawable drawable = context.getResources().getDrawable(R.drawable.pro_ani_list1);
            progressBar.setIndeterminateDrawable(drawable);
        }
        myDialog = new MyDialog(context, R.style.CustomProgressDialog1);
        myDialog.setCanceledOnTouchOutside(false);
        myDialog.setContentView(view);
        Window window = myDialog.getWindow();
        WindowManager.LayoutParams lp = window.getAttributes();
        window.setGravity(Gravity.TOP);
        window.setAttributes(lp);

//        myDialog.getWindow().getAttributes().gravity = Gravity.CENTER - DensityUtil.px2dip(context, 100);
        return myDialog;
    }

    public static MyDialog createDialog2(Context context) {
        ProgressBar progressBar;
        View view = LayoutInflater.from(context).inflate(R.layout.progress_dialog2, null);
        progressBar = (ProgressBar) view.findViewById(R.id.act_detail_progress);
        if (android.os.Build.VERSION.SDK_INT > 22) {//android 6.0替换clip的加载动画
            final Drawable drawable = context.getResources().getDrawable(R.drawable.pro_ani_list1);
            progressBar.setIndeterminateDrawable(drawable);
        }
        myDialog = new MyDialog(context, R.style.CustomProgressDialog1);
        myDialog.setCanceledOnTouchOutside(true);
        myDialog.setContentView(view);
        myDialog.getWindow().getAttributes().gravity = Gravity.CENTER;
        return myDialog;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        if (myDialog == null) {
            return;
        }
        //  ImageView imageView = (ImageView) myDialog.findViewById(R.id.iv_progress_dialog);
        //Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.custom_progress_dialog_animation);
        //imageView.startAnimation(animation);
    }

    public MyDialog setTitle(String title) {
        return myDialog;
    }

    public MyDialog setMessage(String msg) {
        // TextView textView = (TextView) myDialog.findViewById(R.id.tv_progress_dialog);
//        if (textView != null){
//            textView.setText(msg);
//        }
        return myDialog;
    }
}
