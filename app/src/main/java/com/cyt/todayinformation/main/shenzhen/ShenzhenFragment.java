package com.cyt.todayinformation.main.shenzhen;


import android.widget.TextView;

import com.cyt.todayinformation.R;
import com.cyt.todayinformation.base.BaseFragment;
import com.cyt.todayinformation.base.ViewInject;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_others)
public class ShenzhenFragment extends BaseFragment {

    @BindView(R.id.tv_position)
    TextView tvPosition;

    @Override
    public void afterBindView() {
        tvPosition.setText("深圳");
    }
}
