package com.example.mytjfmusic.Views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.mytjfmusic.R;


/**
 * Created by Administrator on 2019-04-09 0009.
 */

public class InputvView extends FrameLayout {


    private int inputIcon;
    private String inputHint;
    private boolean isPassword;
    View mView;
    private ImageView mIvIcon;
    private EditText mEtInput;
    public InputvView(@NonNull Context context) {
        super(context);
        init(context, null);
    }

    public InputvView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public InputvView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }



    public void init(Context context, AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray trpedArray = context.obtainStyledAttributes(attrs, R.styleable.InputvView);

        inputIcon = trpedArray.getResourceId(R.styleable.InputvView_input_icon, R.mipmap.ic_launcher_round);
        inputHint = trpedArray.getString(R.styleable.InputvView_input_hint);
        isPassword = trpedArray.getBoolean(R.styleable.InputvView_input_password, false);
        trpedArray.recycle();
        //绑定布局
        mView = LayoutInflater.from(context).inflate(R.layout.input_view, this, false);
        mIvIcon = mView.findViewById(R.id.input_icon);
        mEtInput = mView.findViewById(R.id.input_edtext);
        mIvIcon.setImageResource(inputIcon);
        mEtInput.setHint(inputHint);
        mEtInput.setInputType(isPassword ? InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_PHONE);
        addView(mView);

    }


    public String getInputStr() {

        return mEtInput.getText().toString().trim();
    }
}
