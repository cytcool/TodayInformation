package com.cyt.todayinformation.main.hangzhou.view;

import android.content.Context;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.cyt.todayinformation.R;
import com.cyt.todayinformation.base.BaseFragment;
import com.cyt.todayinformation.base.ViewInject;
import com.cyt.todayinformation.main.hangzhou.adapter.ZhiHuAdapter;
import com.cyt.todayinformation.main.shanghai.dto.ShanghaiDetailBean;
import com.cyt.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.cyt.todayinformation.main.shanghai.presenter.ShanghaiDetailPresenter;
import com.google.android.material.appbar.AppBarLayout;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_zhihu)
public class ZhiHuFragment extends BaseFragment implements IShanghaiDetailContract.Iview {

    private IShanghaiDetailContract.IPresenter mPresenter = new ShanghaiDetailPresenter(this);


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.zhihu_app_bar_layout)
    AppBarLayout zhihuAppBarLayout;
    @BindView(R.id.zhihu_recycler_view)
    RecyclerView zhihuRecyclerView;

    @Override
    public void afterBindView() {
        zhihuRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mPresenter.getNetData(20);
    }

    @Override
    public void showData(ShanghaiDetailBean data) {
        if (zhihuRecyclerView.getAdapter() == null){
            ZhiHuAdapter zhiHuAdapter = new ZhiHuAdapter(data.result.data);
            zhihuRecyclerView.setAdapter(zhiHuAdapter);
        }
    }
}
