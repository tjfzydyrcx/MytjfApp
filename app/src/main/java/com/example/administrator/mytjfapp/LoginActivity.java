package com.example.administrator.mytjfapp;

import android.text.TextUtils;
import android.widget.EditText;

import com.example.administrator.mytjfapp.Base.BaseActivity;
import com.example.administrator.mytjfapp.HttpProcessor.Http.HttpCallBack;
import com.example.administrator.mytjfapp.HttpProcessor.Http.HttpHelper;
import com.example.administrator.mytjfapp.Utils.LogUtils;
import com.example.administrator.mytjfapp.Utils.MD5;
import com.example.administrator.mytjfapp.Utils.SHA1;
import com.example.administrator.mytjfapp.Utils.StringUrl;
import com.example.administrator.mytjfapp.Utils.TooastUtil;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-04-15 0015.
 */
public class LoginActivity extends BaseActivity {
    @BindView(R.id.login_name)
    EditText mName;
    @BindView(R.id.login_pwd)
    EditText mPwd;


    @OnClick(R.id.login_btn)
    void btnlogin() {
        String name = mName.getText().toString();
        String pwd = mPwd.getText().toString();
        loginHttp(name, pwd);
    }

    private void loginHttp(String name, String pwd) {
        if (TextUtils.isEmpty(name)) {
            TooastUtil.showLong(this, "请输入完整用户名");
            return;
        } else if (TextUtils.isEmpty(pwd)) {
            TooastUtil.showLong(this, "请输入完整密码");
            return;
        } else if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(pwd)) {
            HashMap<String, Object> map = new HashMap<>();
            String signs = SHA1.encode(MD5.GetMD5Code(name + StringUrl.sign));
            map.put("sign", signs);
            map.put("username", name);
            map.put("password", pwd);
            LogUtils.e("password=" + name + pwd);
            HttpHelper.obtain().get(StringUrl.baseLogin, map, new HttpCallBack<String>() {
                @Override
                public void onSuccess(String result) {
                    LogUtils.e("result=" + result.toString());
                }

                @Override
                public void onFailed(String string) {
                    LogUtils.e("onFailed=" + string.toString());
                }
            });

        }
    }


    @Override
    protected int getLayoutViewID() {
        return R.layout.citvity_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void doCreateBusiness() {

    }
}
