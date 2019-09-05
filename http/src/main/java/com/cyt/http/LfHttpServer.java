package com.cyt.http;

import com.cyt.http.request.IRequest;
import com.cyt.http.result.IResult;

import java.util.Map;

public class LfHttpServer {

    protected <T> IResult<T> execute(IRequest request, Map<String,Object> params){
        return HttpHelper.execute(request, params);
    }
}
