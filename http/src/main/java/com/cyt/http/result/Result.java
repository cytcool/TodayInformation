package com.cyt.http.result;


public class Result<T> implements IResult<T> {

    public final static int CODE_200 = 200;
    public final static int CODE_404 = 404;
    public final static int CODE_504 = 504;
    public final static int CODE_505 = 505;

    protected T data;
    protected int code;
    protected boolean success;

    public static IResult success(Object object) {
        Result result = new Result();
        result.code = CODE_200;
        result.data = object;
        result.success = true;
        return result;
    }

    public static IResult failed(int code) {
        Result result = new Result();
        result.code = code;
        result.success = false;
        return result;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public T data() {
        return data;
    }
}
