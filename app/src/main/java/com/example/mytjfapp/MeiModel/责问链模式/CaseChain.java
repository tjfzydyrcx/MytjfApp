package com.example.mytjfapp.MeiModel.责问链模式;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019-04-09 0009.
 */

public class CaseChain implements BaseCase {


    private List<BaseCase> mBaseList=new ArrayList<>();

    private  int index=0;

    public CaseChain addBaseCase(BaseCase baseCase)
    {
        mBaseList.add(baseCase);

        return this;
    }



    @Override
    public void doSomethin(String input, BaseCase baseCase) {
        if (index==mBaseList.size()) return;

        BaseCase currentCase=mBaseList.get(index);
        index++;
        currentCase.doSomethin(input,this);
    }

}
