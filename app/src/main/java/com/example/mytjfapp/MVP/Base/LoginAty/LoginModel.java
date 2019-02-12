package com.example.mytjfapp.MVP.Base.LoginAty;

import com.example.mytjfapp.MVP.Base.ResponseCallback;

public class LoginModel implements LoginContract.Model {

    @Override
    public void login(User user, ResponseCallback callback) {
        if (user == null) {
            callback.onError("", new Exception("用户信息为空").toString());
        }

    }
}