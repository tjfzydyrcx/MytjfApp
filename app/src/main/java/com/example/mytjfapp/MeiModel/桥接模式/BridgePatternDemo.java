package com.example.mytjfapp.MeiModel.桥接模式;

/**
 * Created by Administrator on 2019-02-12 0012.
 * 使用 Shape 和 DrawAPI 类画出不同颜色的圆。
 */

public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 100, 100, 10);
        Shape greenCircle = new Circle(new GreenCircle(), 100, 100, 10);

        redCircle.draw();
        greenCircle.draw();
    }
}
