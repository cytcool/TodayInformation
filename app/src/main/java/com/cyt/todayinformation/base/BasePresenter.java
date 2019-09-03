package com.cyt.todayinformation.base;

import com.cyt.mvp.mvp.IMvpView;
import com.cyt.mvp.mvp.base.BaseMvpPresenter;
import com.cyt.task.LfTask;
import com.cyt.task.TaskHelper;

public abstract class BasePresenter<T extends IMvpView> extends BaseMvpPresenter<T> {

    public BasePresenter(T view) {
        super(view);
    }

    public void submitTask(LfTask task){
        TaskHelper.submitTask(task,task);
    }
}
