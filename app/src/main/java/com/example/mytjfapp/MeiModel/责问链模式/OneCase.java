package com.example.mytjfapp.MeiModel.责问链模式;

/**
 * Created by Administrator on 2019-04-09 0009.
 */

public class OneCase implements BaseCase {
    @Override
    public void doSomethin(String input, BaseCase baseCase) {
          if ("1".equals(input)){
              System.out.println(getClass().getName());
              return;
          }

          baseCase.doSomethin(input,baseCase);
    }
}
