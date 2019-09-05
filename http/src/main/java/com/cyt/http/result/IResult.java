package com.cyt.http.result;

public interface IResult<T> {
    boolean isSuccess();

    int getCode();

    T data();
}
