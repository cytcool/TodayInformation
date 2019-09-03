package com.cyt.http;

import com.cyt.http.okhttp.OkHttpScheduler;
import com.cyt.http.request.IRequest;
import com.cyt.http.request.call.ICall;

import java.util.Map;

public class HttpHelper {

    private volatile static HttpScheduler httpScheduler;

    protected static Object execute(IRequest request, Map<String,Object> params){
        request.setParams(params);
        ICall call = getHttpScheduler().newCall(request);
        Object object = getHttpScheduler().execute(call);
        return object;
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
