package com.example.mytjfapp.MeiModel.观察者模式;

/**
 * Created by Administrator on 2018-11-04 0004.
 */

public class MainObserver {
    public static void main(String[] args) {
        Observable gril=new GrilObservable();//被观察者
        Observer watcher1=new ConcreteObserver("屌丝一号");//观察者
        Observer watcher2=new ConcreteObserver("屌丝二号");
        Observer watcher3=new ConcreteObserver("屌丝三号");
        gril.addObserver(watcher1);
        gril.addObserver(watcher2);
        gril.addObserver(watcher3);
        gril.notifyAllChangs("今天天气整不错");
    }
}
