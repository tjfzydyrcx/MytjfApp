package com.example.mytjfapp;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mymvp.Views.HintSideBar;
import com.example.mymvp.Views.SideBar;
import com.example.mymvp.network.HttpProcessor.Http.HttpCallBack;
import com.example.mymvp.network.HttpProcessor.Http.HttpHelper;
import com.example.mytjfapp.Adapter.UserAdapter;
import com.example.mytjfapp.Base.BaseActivity;
import com.example.mytjfapp.MVP.Base.LoginAty.User;
import com.example.mytjfapp.Utils.LogUtils;
import com.example.mytjfapp.Utils.MD5;
import com.example.mytjfapp.Utils.SHA1;
import com.example.mytjfapp.Utils.StringUrl;
import com.example.mytjfapp.Utils.TooastUtil;
import com.example.mytjfapp.View.VerticalSeekBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-04-15 0015.
 */
public class LoginActivity extends BaseActivity implements SideBar.OnChooseLetterChangedListener {
    @BindView(R.id.login_name)
    EditText mName;
    @BindView(R.id.login_pwd)
    EditText mPwd;
    @BindView(R.id.rv_userList)
    RecyclerView rvUserList;
    @BindView(R.id.hintSideBar)
    HintSideBar hintSideBar;
    @BindView(R.id.bar_add)
    TextView barAdd;
    @BindView(R.id.bar_sub)
    TextView barSub;
    @BindView(R.id.VerticalSeekBar)
    com.example.mytjfapp.View.VerticalSeekBar VerticalSeekBar;


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
            Map<String, String> map = new HashMap<>();
            String signs = SHA1.encode(MD5.GetMD5Code(name + StringUrl.sign));
            map.put("sign", signs);
            map.put("username", name);
            map.put("password", pwd);
            LogUtils.e("password=" + name + pwd);
            HttpHelper.obtain().get(StringUrl.baseLogin, map, new HttpCallBack<String>() {
                @Override
                public String onSuccess(String result) {
                    LogUtils.e("result=" + result.toString());
                    return null;
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

    private List<User> userList;

    private UserAdapter adapter;


    private LinearLayoutManager manager;

    @Override
    protected void doCreateBusiness() {

        hintSideBar.setOnChooseLetterChangedListener(this);
        manager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvUserList.setLayoutManager(manager);
        userList = new ArrayList<>();
        adapter = new UserAdapter(this);
        initData();
        adapter.setData(userList);
        rvUserList.setAdapter(adapter);


        barAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (VerticalSeekBar.getProgress() >= 100) {
                    VerticalSeekBar.setProgress(100);
                } else if (VerticalSeekBar.getProgress() < 100) {
                    VerticalSeekBar.setProgress(VerticalSeekBar.getProgress() + 5);
                }

            }
        });
        barSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (VerticalSeekBar.getProgress() > 0) {
                    VerticalSeekBar.setProgress(VerticalSeekBar.getProgress() - 5);
                } else if (VerticalSeekBar.getProgress() <= 0) {
                    VerticalSeekBar.setProgress(0);
                }

            }
        });
    }


    public void initData() {
        User user1 = new User("陈", "12345678");
        User user2 = new User("赵", "12345678");
        User user3 = new User("南", "12345678");
        User user4 = new User("司徒", "12345678");
        User user5 = new User("李", "12345678");
        User user6 = new User("Y", "12345678");
        User user7 = new User("C", "12345678");
        User user8 = new User("吴", "12345678");
        User user9 = new User("钱", "12345678");
        User user10 = new User("蔡", "12345678");
        User user11 = new User("许", "12345678");
        User user12 = new User("沈", "12345678");
        User user13 = new User("吴", "12345678");
        User user14 = new User("邑", "12345678");
        User user15 = new User("A", "12345678");
        User user16 = new User("#奇怪符号", "12345678");
        User user17 = new User("@神奇符号", "12345678");
        User user18 = new User("s", "12345678");
        User user19 = new User("孙", "12345678");
        User user20 = new User("周", "12345678");
        User user21 = new User("A郑", "12345678");
        User user22 = new User("王", "12345678");
        User user23 = new User("黄", "12345678");
        User user24 = new User("弟", "12345678");
        User user25 = new User("浩", "12345678");
        User user26 = new User("BA郑", "12345678");
        User user27 = new User("应", "12345678");
        User user28 = new User("徐", "12345678");
        User user29 = new User("刘", "12345678");
        User user30 = new User("弟", "12345678");
        User user31 = new User("浩", "12345678");
        User user32 = new User("胡", "12345678");
        User user33 = new User("胡", "12345678");
        User user34 = new User("修", "12345678");
        User user35 = new User("秀", "12345678");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user7);
        userList.add(user8);
        userList.add(user9);
        userList.add(user10);
        userList.add(user11);
        userList.add(user12);
        userList.add(user13);
        userList.add(user14);
        userList.add(user15);
        userList.add(user16);
        userList.add(user17);
        userList.add(user18);
        userList.add(user19);
        userList.add(user20);
        userList.add(user21);
        userList.add(user22);
        userList.add(user23);
        userList.add(user24);
        userList.add(user25);
        userList.add(user26);
        userList.add(user27);
        userList.add(user28);
        userList.add(user29);
        userList.add(user30);
        userList.add(user31);
        userList.add(user32);
        userList.add(user33);
        userList.add(user34);
        userList.add(user35);
        userList.add(user20);
        userList.add(user21);
        userList.add(user22);
        userList.add(user23);
        userList.add(user24);
        userList.add(user25);
        userList.add(user26);
        userList.add(user27);
        userList.add(user28);
        userList.add(user29);
        userList.add(user30);
        userList.add(user31);
        userList.add(user32);
        userList.add(user33);
        userList.add(user34);
        userList.add(user35);
        Collections.sort(userList);
    }

    @Override
    public void onChooseLetter(String s) {
        int i = adapter.getFirstPositionByChar(s.charAt(0));
        if (i == -1) {
            return;
        }
        manager.scrollToPositionWithOffset(i, 0);
    }

    @Override
    public void onNoChooseLetter() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    private Button btn_determine;
    private Button btn_cancel;
    private AlertDialog dlg;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        //判断如果单击了返回按钮
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //创建对话框实例
            dlg = new AlertDialog.Builder(this).create();
            dlg.show();//显示对话框
            Window window = dlg.getWindow();//对话框窗口
            window.setGravity(Gravity.CENTER);//设置对话框显示在屏幕中间
            window.setWindowAnimations(R.style.dialog_style);//添加动画
            window.setContentView(R.layout.dialog_layout);//设置对话框的布局文件
            //获取对话框确定和取消按钮
            btn_determine = window.findViewById(R.id.btn_determine);
            btn_cancel = window.findViewById(R.id.btn_cancel);
            initEvent();//初始化事件
        }
        return super.onKeyDown(keyCode, event);
    }
    private void initEvent() {
        //确定
        btn_determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();//关闭对话框
                finish();//退出当前界面
            }
        });

        //取消
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.dismiss();//关闭对话框
            }
        });
    }
}
