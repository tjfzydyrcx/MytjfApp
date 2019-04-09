package com.example.mytjfapp.MeiModel.责问链模式;

/**
 * Created by Administrator on 2019-04-09 0009.
 */

public interface BaseCase {

    void  doSomethin(String input,BaseCase baseCase);
}
