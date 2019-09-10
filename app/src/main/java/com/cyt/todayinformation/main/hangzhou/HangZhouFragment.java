package com.cyt.todayinformation.main.hangzhou;


import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cyt.todayinformation.R;
import com.cyt.todayinformation.base.BaseFragment;
import com.cyt.todayinformation.base.ViewInject;
import com.cyt.todayinformation.main.hangzhou.view.ZhiHuFragment;
import com.cyt.todayinformation.main.shenzhen.ShenZhenFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_hangzhou)
public class HangZhouFragment extends BaseFragment {


    @BindView(R.id.tl_tablayout)
    TabLayout tlTablayout;
    @BindView(R.id.vp_viewpager)
    ViewPager vpViewpager;
    @Override
    public void afterBindView() {

        tlTablayout.setupWithViewPager(vpViewpager);
        vpViewpager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Log.d("ZhiHuFragment","position" + position);
                return new ZhiHuFragment();
            }

            @Override
            public int getCount() {
                return 1;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return "知乎";
            }
        });
    }
}
