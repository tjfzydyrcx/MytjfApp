package com.example.mytjfapp.MeiModel.观察者模式;

/**
 * Created by Administrator on 2018-11-04 0004.
 * 被观察者
 */

public interface Observable  {

    void addObserver(Observer observer);
    void notifyAllChangs(String string);
    void removeObserver(Observer observer);
}
