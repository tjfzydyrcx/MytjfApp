package com.example.mytjfapp.MeiModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018-11-04 0004.
 */

public class GrilObservable implements Observable {
    //被观察者
    private List<Observer> list = new ArrayList<>();
   //添加观察者
    @Override
    public void addObserver(Observer observer) {
        list.add(observer);
    }
    //发送消息
    @Override
    public void notifyAllChangs(String string) {
        for (Observer watcher : list) {
            watcher.update(string);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        list.remove(observer);
    }
}
