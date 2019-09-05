package com.cyt.todayinformation.main.shanghai.lf;


import com.cyt.mvp.mvp.ILifeCircle;
import com.cyt.mvp.mvp.IMvpView;
import com.cyt.mvp.mvp.MvpController;

public interface IShanghaiDetailContract {

    interface Iview extends IMvpView {

    }

    interface IPresenter extends ILifeCircle {


        void getNetData();
    }

    IShanghaiDetailContract.Iview emptyView = new IShanghaiDetailContract.Iview() {


        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
