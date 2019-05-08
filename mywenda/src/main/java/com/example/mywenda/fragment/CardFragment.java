package com.example.mywenda.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymvp.base.BaseFragment;
import com.example.mywenda.R;
import com.example.mywenda.bean.Questioninfo;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2019-04-27 0027.
 */

public class CardFragment extends BaseFragment {
    @BindView(R.id.title_name)
    TextView titleName;
    @BindView(R.id.tv_option1)
    TextView tvOption1;
    @BindView(R.id.tv_option2)
    TextView tvOption2;
    @BindView(R.id.tip_tv_text)
    TextView tipTvText;
    private Questioninfo questioninfo;
    public static CardFragment newInstance(Questioninfo info) {
        CardFragment fragment = new CardFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("info", info);
        fragment.setArguments(bundle);
        return fragment;

    }
    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        return rootView;
    }

    @Override
    public void initData() {
        questioninfo= (Questioninfo) getArguments().getSerializable("info");
        titleName.setText(questioninfo.getTitle());

    }

    @Override
    protected void initListener() {

    }


}
