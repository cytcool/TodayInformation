package com.cyt.http.parser;

import com.cyt.http.request.IRequest;
import com.cyt.http.response.IResponse;
import com.cyt.http.result.IResult;
import com.cyt.http.result.Result;
import com.google.gson.Gson;

import java.lang.reflect.Type;

public class DefaultResultParser implements IParser {

    private static DefaultResultParser mInstance;
    private Gson mGson;

    private DefaultResultParser() {
        mGson = new Gson();
    }

    public static IParser getInstance() {
        if (mInstance == null) {
            mInstance = new DefaultResultParser();
        }
        return mInstance;
    }

    @Override
    public IResult parseResponse(IRequest request, IResponse response) {
        Type type = request.getType();
        String bodyStr = response.getBodyStr();
        Object object = mGson.fromJson(bodyStr, type);
        return Result.success(object);

    }
}
