package com.example.mytjfapp.MeiModel.桥接模式;

/**
 * Created by Administrator on 2019-02-12 0012.
 * 桥接接口实现类 红色
 */

public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("Drawing Circle[ color: red, radius: "
                + radius +", x: " +x+", "+ y +"]");
    }
}
