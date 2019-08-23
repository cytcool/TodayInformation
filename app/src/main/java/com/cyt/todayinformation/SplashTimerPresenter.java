package com.cyt.todayinformation;

public class SplashTimerPresenter {

    private CustomCountDownTimer mCustomCountDownTimer;
    private SplashActivity mActivity;

    public SplashTimerPresenter(SplashActivity activity){
        this.mActivity = activity;
    }

    public void initTimer(){
        mCustomCountDownTimer = new CustomCountDownTimer(5, new CustomCountDownTimer.ICountDownHandler() {
            @Override
            public void onTicker(int time) {
                mActivity.setTvTimer(time + "秒");
            }

            @Override
            public void onFinish() {
                mActivity.setTvTimer("跳过");
            }
        });

        mCustomCountDownTimer.start();
    }

    public void cancel(){
        mCustomCountDownTimer.cancel();
    }
}
