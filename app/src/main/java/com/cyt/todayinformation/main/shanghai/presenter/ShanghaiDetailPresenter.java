package com.cyt.todayinformation.main.shanghai.presenter;

import com.cyt.mvp.mvp.base.BaseMvpPresenter;
import com.cyt.task.LfTask;
import com.cyt.todayinformation.base.BasePresenter;
import com.cyt.todayinformation.main.shanghai.lf.IShanghaiDetailContract;
import com.cyt.todayinformation.main.shanghai.module.ShangHaiDetailHttpServer;

public class ShanghaiDetailPresenter extends BasePresenter<IShanghaiDetailContract.Iview> implements IShanghaiDetailContract.IPresenter {

    public ShanghaiDetailPresenter(IShanghaiDetailContract.Iview view) {
        super(view);
    }

    @Override
    protected IShanghaiDetailContract.Iview getEmptyView() {
        return IShanghaiDetailContract.emptyView;
    }

    @Override
    public void getNetData() {
        submitTask(new LfTask() {
            @Override
            public void onSuccess(Object o) {

            }

            @Override
            public void onException(Throwable throwable) {

            }

            @Override
            public Object onBackground() {
                return new ShangHaiDetailHttpServer().getXiaoHuaList("desc","1","1");
            }
        });
    }


}
