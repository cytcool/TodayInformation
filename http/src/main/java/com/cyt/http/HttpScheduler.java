package com.cyt.http;

import com.cyt.http.request.IRequest;
import com.cyt.http.request.call.ICall;

public abstract class HttpScheduler {
    public abstract ICall newCall(IRequest request);

    public  Object execute(ICall call){
        return call.execute();
    }
}
