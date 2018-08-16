package com.example.administrator.mytjfapp.Adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.administrator.mytjfapp.Fragments.ReadFramgnet;
import com.example.administrator.mytjfapp.Model.MeiziBean;
import com.example.administrator.mytjfapp.R;
import com.example.administrator.mytjfapp.Utils.GlideUtils;
import com.lid.lib.LabelImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018-08-10 0010.
 */

public class MeiziAdapter extends BaseQuickAdapter<MeiziBean.ResultsBean, BaseViewHolder> {
    Context context;

    public MeiziAdapter(Context context, @LayoutRes int layoutResId, @Nullable List<MeiziBean.ResultsBean> data) {
        super(layoutResId, data);
        this.context = context;
    }


    @Override
    protected void convert(BaseViewHolder helper, MeiziBean.ResultsBean item) {

        LabelImageView labelImageView = helper.getView(R.id.meizis);
        labelImageView.setLabelTextColor(Color.BLACK);
        labelImageView.setLabelTextSize(14);
        labelImageView.setLabelText(item.getSource());
        GlideUtils.loadImage(context, item.getUrl(), labelImageView);
       helper.setText(R.id.text_time,item.getDesc());

    }


}
