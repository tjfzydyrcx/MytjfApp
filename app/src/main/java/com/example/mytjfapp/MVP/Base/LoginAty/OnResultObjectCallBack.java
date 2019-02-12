package com.example.mytjfapp.MVP.Base.LoginAty;

import com.example.mytjfapp.MVP.Base.BaseBean;
import com.example.mytjfapp.MVP.Base.ResponseCallback;

/**
 * Created by Administrator on 2019-01-05 0005.
 */

interface OnResultObjectCallBack<T extends BaseBean>  extends ResponseCallback{



    public void onCompleted() ;

}
