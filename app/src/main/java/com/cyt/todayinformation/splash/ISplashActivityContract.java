package com.cyt.todayinformation.splash;

import com.cyt.mvp.mvp.ILifeCircle;
import com.cyt.mvp.mvp.IMvpView;
import com.cyt.mvp.mvp.MvpController;

public interface ISplashActivityContract {

    interface Iview extends IMvpView {
        void setTvTimer(String timer);
    }

    interface IPresenter extends ILifeCircle {
        void initTimer();
    }

    Iview emptyView = new Iview() {
        @Override
        public void setTvTimer(String timer) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
