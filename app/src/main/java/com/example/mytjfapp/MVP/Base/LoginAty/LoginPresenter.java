package com.example.mytjfapp.MVP.Base.LoginAty;

import com.example.mytjfapp.MVP.Base.BasePresenter;

public class LoginPresenter extends BasePresenter<LoginContract.Model, LoginContract.View>
        implements LoginContract.Presenter {

    @Override
    public void login() {
        if (isViewAttached()) {
            getView().showLoading();
            getModule().login(getView().getUserInfo(), new OnResultObjectCallBack<User>() {
                @Override
                public void onError(String strerr1, String strerr) {

                }

                @Override
                public void onSuccess(String strsus) {

                }



                @Override
                public void onCompleted() {
                    getView().dismissLoading();
                }
            });
        }
    }

    @Override
    protected LoginModel createModule() {
        return new LoginModel();
    }

    @Override
    public void start() { }
}