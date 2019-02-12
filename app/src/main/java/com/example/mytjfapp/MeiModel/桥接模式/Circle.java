package com.example.mytjfapp.MeiModel.桥接模式;

/**
 * Created by Administrator on 2019-02-12 0012.
 * 创建实现了 Shape 接口的实体类。
 */

public class Circle extends Shape {


    private int x, y, radius;

    public Circle(DrawAPI drawAPI, int x, int y, int radius) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
       drawAPI.drawCircle(radius,x,y);
    }
}
