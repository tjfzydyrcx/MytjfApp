package com.example.mytjfapp.MVP.Base;


import com.example.mytjfapp.MVP.Base.LoginAty.User;

/**
 * Created by Administrator on 2019-01-05 0005.
 */

public interface ResponseCallback {

    void onError(String strerr1,String strerr);
    void onSuccess(String strsus);
}
