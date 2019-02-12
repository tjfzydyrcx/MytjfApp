package com.example.mytjfapp.MVP.Base;


public interface  Contract {

    interface Model extends IBaseModel {
        void login(BaseBean bean, ResponseCallback callback);
    }

    interface View extends IBaseView {
        BaseBean getUserInfo();
        void loginSuccess(BaseBean user);
    }

    interface Presenter {
        void login();
    }
}