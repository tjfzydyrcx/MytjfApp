package com.example.mytjfapp.MVP.Base.LoginAty;

import com.example.mytjfapp.MVP.Base.Contract;
import com.example.mytjfapp.MVP.Base.IBaseModel;
import com.example.mytjfapp.MVP.Base.IBaseView;
import com.example.mytjfapp.MVP.Base.ResponseCallback;

/**
 * Created by Administrator on 2019-01-05 0005.
 */

public class LoginContract {interface Model extends IBaseModel {

    /**
     * 登录
     *
     * @param user     用户信息
     * @param callback 回调
     */
    void login(User user, ResponseCallback callback);
}

    interface View extends IBaseView {


        /**
         * 返回用户信息
         */
        User getUserInfo();

        /**
         * 登录成功
         */
        void loginSuccess(User user);

    }

    interface Presenter {

        /**
         * 登录
         */
        void login();
    }

}
