package com.cyt.task;

public interface ITaskCallback {

    void onSuccess(Object o);

    void onException(Throwable throwable);
}
