package com.cyt.todayinformation.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.cyt.mvp.mvp.view.LifeCircleMvpFragment;

import butterknife.ButterKnife;

public abstract class BaseFragment extends LifeCircleMvpFragment {

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mContext = context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = null;
        ViewInject annotation = this.getClass().getAnnotation(ViewInject.class);
        if (annotation != null){
            int mainlayoutid = annotation.mainlayoutid();
            if (mainlayoutid >0 ){
                mView = initFragmentView(inflater,mainlayoutid);
                bindView(mView);
                afterBindView();
            }else {
                throw new RuntimeException("mainlayoutid < 0");
            }
        }else {
            throw new RuntimeException("annotation = null");
        }
        return mView;

    }

    private View initFragmentView(LayoutInflater inflater,int mainlayoutid) {

        return inflater.inflate(mainlayoutid,null);
    }


    public abstract void afterBindView();

    // View 的依赖注入绑定
    private void bindView(View view){
        ButterKnife.bind(this,view);
    }
}
