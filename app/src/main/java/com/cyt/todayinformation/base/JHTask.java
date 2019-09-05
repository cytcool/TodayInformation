package com.cyt.todayinformation.base;

import com.cyt.http.result.IResult;
import com.cyt.http.result.IResultCallBack;
import com.cyt.http.result.Result;
import com.cyt.task.LfTask;

public abstract class JHTask<T> extends LfTask<IResult<T>> implements IResultCallBack<T> {


    @Override
    public void onComplete(IResult<T> iResult) {
        if (iResult != null) {
            if (iResult.isSuccess()) {
                onSuccess(iResult);
            } else {
                onFailed(Result.failed(Result.CODE_505));// 1次失败
            }
        } else {
            onFailed(Result.failed(Result.CODE_404));// 2次失败
        }
    }

    @Override
    public void onFailed(IResult<T> t) {
        switch (t.getCode()){
            case Result.CODE_404:
                break;
            case Result.CODE_505:
                break;
        }
    }

    @Override
    public void onException(Throwable throwable) {
        onFailed(Result.failed(Result.CODE_504));// 3次失败
    }
}
