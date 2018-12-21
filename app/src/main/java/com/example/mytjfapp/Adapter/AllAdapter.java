package com.example.mytjfapp.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.mytjfapp.Model.AllBean;
import com.example.mytjfapp.R;

import java.util.List;

/**
 * Created by Administrator on 2018-08-14 0014.
 */

public class AllAdapter extends BaseQuickAdapter<AllBean.ResultsBean, BaseViewHolder> {
    Context context;

    public AllAdapter(Context context, @LayoutRes int layoutResId, @Nullable List<AllBean.ResultsBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, AllBean.ResultsBean item) {
        helper.setText(R.id.tv_title, item.getDesc());
        helper.setText(R.id.tv_name, item.getWho());
        helper.setText(R.id.tv_publishtime, item.getPublishedAt());

    }

}