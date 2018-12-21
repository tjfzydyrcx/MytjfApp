package com.example.mytjfapp.MeiModel;

import com.example.mytjfapp.Utils.LogUtils;

/**
 * Created by Administrator on 2018-11-04 0004.
 */

public class ConcreteObserver implements Observer {
  //  观察者
    private String name;
    public ConcreteObserver(String name) {
        this.name=name;
    }
    //接收更新
    @Override
    public void update(String str) {
        System.out.println(name+"观察者接收到了信息="+str);
    }
}
