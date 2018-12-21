package com.example.mytjfapp.MeiModel;

/**
 * Created by Administrator on 2018-11-04 0004.
 */

public interface Observable  {

    void addObserver(Observer observer);
    void notifyAllChangs(String string);
    void removeObserver(Observer observer);
}
