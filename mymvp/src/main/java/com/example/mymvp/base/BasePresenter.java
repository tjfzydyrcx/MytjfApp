package com.example.mymvp.base;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * Created by Administrator on 2019-01-06 0006.
 */

public abstract class BasePresenter<M, V> {

    protected M mModel;
    protected WeakReference<V> mViweRef;


    protected void onAttach(M mModel, V view) {
        this.mModel = mModel;
        this.mViweRef = new WeakReference<V>(view);

    }


    protected V getView() {
        return isViewAttached() ? mViweRef.get() : null;

    }

    protected boolean isViewAttached() {
        return null != mViweRef && null != mViweRef.get();
    }

    protected  void onDetach(){
        if (null!=mViweRef){
            mViweRef.clear();
            mViweRef=null;
        }
    }
}
