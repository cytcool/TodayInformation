package com.cyt.http;

import com.cyt.http.okhttp.OkHttpScheduler;
import com.cyt.http.request.IRequest;
import com.cyt.http.request.call.ICall;
import com.cyt.http.result.IResult;

import java.util.Map;

public class HttpHelper {

    private volatile static HttpScheduler httpScheduler;

    protected static <T> IResult<T> execute(IRequest request, Map<String,Object> params){
        request.setParams(params);
        ICall call = getHttpScheduler().newCall(request);
        return getHttpScheduler().execute(call);
    }

    private static HttpScheduler getHttpScheduler() {
        if (httpScheduler == null){
            synchronized (HttpHelper.class){
                if (httpScheduler == null){
                    httpScheduler = new OkHttpScheduler();
                }
            }
        }
        return httpScheduler;
    }
}
