package com.cyt.todayinformation.splash;

import com.cyt.todayinformation.mvp.base.BaseMvpPresenter;

public class SplashTimerPresenter extends BaseMvpPresenter<ISplashActivityContract.Iview> implements ISplashActivityContract.IPresenter {

    private CustomCountDownTimer mCustomCountDownTimer;

    public SplashTimerPresenter(ISplashActivityContract.Iview view) {
        super(view);
    }


    public void initTimer(){
        mCustomCountDownTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                getView().setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                getView().setTvTimer("跳过");
            }
        });

        mCustomCountDownTimer.start();
    }

    public void cancel(){
        mCustomCountDownTimer.cancel();
    }


    @Override
    protected ISplashActivityContract.Iview getEmptyView() {
        return ISplashActivityContract.emptyView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        cancel();
    }
}
