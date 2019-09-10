package com.cyt.todayinformation.main.shanghai.lf;


import com.cyt.mvp.mvp.ILifeCircle;
import com.cyt.mvp.mvp.IMvpView;
import com.cyt.mvp.mvp.MvpController;
import com.cyt.todayinformation.main.shanghai.dto.ShanghaiDetailBean;

public interface IShanghaiDetailContract {

    interface Iview extends IMvpView {

        void showData(ShanghaiDetailBean data);
    }

    interface IPresenter extends ILifeCircle {


        void getNetData(int pagesize);
    }

    IShanghaiDetailContract.Iview emptyView = new IShanghaiDetailContract.Iview() {


        @Override
        public void showData(ShanghaiDetailBean data) {

        }

        @Override
        public MvpController getMvpController() {
            return null;
        }
    };
}
