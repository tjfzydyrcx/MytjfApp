package com.example.administrator.mytjfapp;

import android.os.Handler;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.example.administrator.mytjfapp.Base.BaseActivity;
import com.example.administrator.mytjfapp.HttpProcessor.Http.HttpCallBack;
import com.example.administrator.mytjfapp.HttpProcessor.Http.HttpHelper;
import com.example.administrator.mytjfapp.Utils.MyDialog;
import com.example.administrator.mytjfapp.Utils.SHA1;
import com.example.administrator.mytjfapp.Utils.StringUrl;
import com.example.administrator.mytjfapp.Utils.ToastUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-04-15 0015.
 */
public class LoginActivity1 extends BaseActivity {
    Handler handler = new Handler();

    @BindView(R.id.main_btn_login)
    TextView mBtnLogin;
    private MyDialog mMyDialog;
    @BindView(R.id.checkBox1)
    CheckBox checkBox;
    @BindView(R.id.input_layout_name)
    TextView mName;
    @BindView(R.id.input_layout_psw)
    TextView mPwd;

    @Override
    protected void initView() {

    }

    @Override
    protected void bindListener() {

    }

    @Override
    protected int getLayoutViewID() {
        return R.layout.layout_login_main;
    }

    @Override
    protected void doCreateBusiness() {
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // TODO Auto-generated method stub
                if (isChecked) {
                    //如果选中，显示密码
                    mPwd.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //否则隐藏密码
                    mPwd.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });
    }

    @OnClick(R.id.main_btn_login)
    void btnlogin() {
        String name = mName.getText().toString();
        String pwd = mPwd.getText().toString();
        loginHttp(name, pwd);
    }

    private void loginHttp(final String name, final String pwd) {
        if (TextUtils.isEmpty(name)) {
            ToastUtil.showLong(this, "请输入完整用户名");
            return;
        } else if (TextUtils.isEmpty(pwd)) {
            ToastUtil.showLong(this, "请输入完整密码");
            return;
        } else if (pwd.length() < 8 || pwd.length() > 16) {
            ToastUtil.showLong(this, "密码位数不对");
            return;
        } else if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
            showDialog();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    mMyDialog.dismiss();

                }
            }, 2000);
        }
    }

    private void showDialog() {
        mMyDialog = MyDialog.createDialog1(this);
        mMyDialog.show();
    }
}
