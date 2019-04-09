package com.example.mytjfapp.MeiModel.桥接模式;

/**
 * Created by Administrator on 2019-02-12 0012.
 * 使用 Shape 和 DrawAPI 类画出不同颜色的圆。
 * 桥接（Bridge）是用于把抽象化与实现化解耦，使得二者可以独立变化。
 *
 *
 * 优点： 1、抽象和实现的分离。 2、优秀的扩展能力。 3、实现细节对客户透明。
 */

public class BridgePatternDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 100, 100, 10);
        Shape greenCircle = new Circle(new GreenCircle(), 100, 100, 10);

        redCircle.draw();
        greenCircle.draw();
    }
}
