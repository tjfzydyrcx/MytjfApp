package com.example.mytjfapp.TjfMvp.Fragment.Grilmvp;

import com.example.mymvp.base.BaseModel;
import com.example.mymvp.base.BasePresenter;
import com.example.mymvp.base.BaseView;
import com.example.mymvp.base.MvpListener;
import com.example.mytjfapp.Model.MeiziBean;

import java.util.List;

/**
 *
 * @author Administrator
 * @date 2019-01-19 0019
 */

public   class MeiziContract {

    interface MeiziModel extends BaseModel {
        void loadMeizi(String url, MvpListener<List<MeiziBean.ResultsBean>> listener);
    }

    public interface MeizView extends BaseView {
        void setData(List<MeiziBean.ResultsBean> beanList);

    }

   abstract static class MeiziPresenter extends BasePresenter<MeiziModel,MeizView> {
       protected abstract void loadData(String url);
    }
}
