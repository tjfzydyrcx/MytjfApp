package com.example.mytjfapp.TjfMvp.Fragment.Textmvp;

import com.example.mymvp.base.BaseModel;
import com.example.mymvp.base.BasePresenter;
import com.example.mymvp.base.BaseView;
import com.example.mymvp.base.MvpListener;
import com.example.mytjfapp.Model.AllBean;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.TjfMvp.Fragment.Grilmvp.MeiziContract;

import java.util.List;

/**
 * Created by Administrator on 2019-02-13 0013.
 */

public class TextContract {
  public   interface TextsModel extends BaseModel {
        void loadText(String url, MvpListener<List<AllBean.ResultsBean>> listener);
    }

    public  interface TextsView extends BaseView {
        void setData(List<AllBean.ResultsBean> beanList);

    }

    public   abstract static class TextPresenter extends BasePresenter<TextContract.TextsModel, TextContract.TextsView> {
        protected abstract void loadData(String url);
    }

}
