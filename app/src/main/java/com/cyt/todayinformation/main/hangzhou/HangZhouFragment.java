package com.cyt.todayinformation.main.hangzhou;


import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.cyt.todayinformation.R;
import com.cyt.todayinformation.base.BaseFragment;
import com.cyt.todayinformation.base.ViewInject;
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
                Log.d("HangZhouFragment","position" + position);
                return new ShenZhenFragment();
            }

            @Override
            public int getCount() {
                return 5;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                return "深圳";
            }
        });
    }
}
