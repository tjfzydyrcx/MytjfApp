package com.example.mytjfapp.MeiModel.责问链模式;

/**
 * Created by Administrator on 2019-04-09 0009.
 * <p>
 * 责任链模式是一条链，链上有多个节点，每个节点都有各自的责任。
 * 当有输入时，第一个责任节点看自己能否处理该输入，如果可以就处理。
 * 如果不能就交由下一个责任节点处理。依次类推，直到最后一个责任节点。
 */

public class MainCase {

    public static void main(String[] args) {
        String input = "1";

        CaseChain caseChain = new CaseChain();
        caseChain.addBaseCase(new OneCase()).addBaseCase(new TwoCase()).doSomethin(input, caseChain);
    }
}
