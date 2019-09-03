package com.cyt.http;

import com.cyt.http.request.IRequest;

import java.util.Map;

public class LfHttpServer {

    protected Object execute(IRequest request, Map<String,Object> params){
        return HttpHelper.execute(request, params);
    }
}
