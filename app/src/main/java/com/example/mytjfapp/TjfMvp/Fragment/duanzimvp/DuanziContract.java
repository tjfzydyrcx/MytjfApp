package com.example.mytjfapp.TjfMvp.Fragment.duanzimvp;

import com.example.mymvp.base.BaseModel;
import com.example.mymvp.base.BasePresenter;
import com.example.mymvp.base.BaseView;
import com.example.mymvp.base.MvpListener;
import com.example.mytjfapp.Model.DuanziBean;
import com.example.mytjfapp.Model.MeiziBean;
import com.example.mytjfapp.TjfMvp.Fragment.Grilmvp.MeiziContract;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2019-03-08 0008.
 */

public class DuanziContract {

    interface DuanziModel extends BaseModel {

        void loadDuanzi(String url, HashMap<String, String> map, MvpListener<List<DuanziBean.ResultBean>> listener);
    }

    public interface DuanziView extends BaseView {
        void setData(List<DuanziBean.ResultBean> beanList);

    }

    abstract static class DuanziPresenter extends BasePresenter<DuanziContract.DuanziModel, DuanziContract.DuanziView> {
        protected abstract void loadData(String url, HashMap<String,String> map);
    }
}
