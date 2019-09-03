package com.cyt.http.okhttp;


import com.cyt.http.request.IRequest;
import com.cyt.http.request.call.ICall;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Response;


public class OkHttpCall implements ICall {

    private Call call;

    public OkHttpCall(IRequest request, Call call){
        this.call = call;
    }

    @Override
    public Object execute() {
        Response response = null;
        try {
             response = call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
