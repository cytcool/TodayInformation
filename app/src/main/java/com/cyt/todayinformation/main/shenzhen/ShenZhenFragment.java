package com.cyt.todayinformation.main.shenzhen;


import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.cyt.todayinformation.R;
import com.cyt.todayinformation.base.BaseFragment;
import com.cyt.todayinformation.base.ViewInject;

import butterknife.BindView;

@ViewInject(mainlayoutid = R.layout.fragment_others)
public class ShenZhenFragment extends BaseFragment {

    @BindView(R.id.tv_position)
    TextView tvPosition;

    @Override
    public void afterBindView() {
        tvPosition.setText("深圳");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("ShenZhenFragment", "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ShenZhenFragment", "onCreate");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d("ShenZhenFragment", "onPause");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d("ShenZhenFragment", "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("ShenZhenFragment", "onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d("ShenZhenFragment", "onDetach");
    }
}
