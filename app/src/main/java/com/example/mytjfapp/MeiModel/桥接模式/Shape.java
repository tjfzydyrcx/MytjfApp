package com.example.mytjfapp.MeiModel.桥接模式;

/**
 * Created by Administrator on 2019-02-12 0012.
 *
 * DrawAPI 接口创建抽象类 Shape。
 *
 */

public abstract class Shape {

  protected  DrawAPI drawAPI;

    public Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public  abstract  void  draw();
}
