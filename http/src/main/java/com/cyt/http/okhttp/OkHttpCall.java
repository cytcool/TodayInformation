package com.cyt.http.okhttp;


import com.cyt.http.request.IRequest;
import com.cyt.http.request.call.ICall;
import com.cyt.http.response.IResponse;
import com.cyt.http.result.IResult;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;


public class OkHttpCall implements ICall {

    private Call call;
    private IRequest request;

    public OkHttpCall(IRequest request, Call call){
        this.request = request;
        this.call = call;
    }

    @Override
    public IResponse execute() {
        Response response = null;
        try {
             response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        OkHttpResponse okHttpResponse = new OkHttpResponse(response);
        return okHttpResponse;
    }

    @Override
    public IRequest getRequest() {
        return request;
    }
}
