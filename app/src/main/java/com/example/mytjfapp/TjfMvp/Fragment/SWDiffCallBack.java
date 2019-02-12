package com.example.mytjfapp.TjfMvp.Fragment;

import android.support.v7.util.DiffUtil;

import com.example.mytjfapp.Model.MeiziBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2019-02-12 0012.
 */

public class SWDiffCallBack extends DiffUtil.Callback {
    List<MeiziBean.ResultsBean> list ;
    List<MeiziBean.ResultsBean> list1 ;

    public SWDiffCallBack(List<MeiziBean.ResultsBean> list, List<MeiziBean.ResultsBean> list1) {
        this.list = list;
        this.list1 = list1;
    }

    @Override
    public int getOldListSize() {
        return list.size();
    }

    @Override
    public int getNewListSize() {
        return list1.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return list.get(oldItemPosition).equals(list1.get(newItemPosition));
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return list.get(oldItemPosition).equals(list1.get(newItemPosition));
    }
}
