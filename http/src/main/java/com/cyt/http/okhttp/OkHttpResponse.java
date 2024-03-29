package com.cyt.http.okhttp;

import com.cyt.http.response.IResponse;

import java.io.IOException;

import okhttp3.Response;

public class OkHttpResponse implements IResponse {

    private Response response;

    public OkHttpResponse(Response response) {
        this.response = response;
    }

    @Override
    public String getBodyStr() {
        try {
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
