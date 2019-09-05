package com.cyt.http;

import com.cyt.http.parser.IParser;
import com.cyt.http.request.IRequest;
import com.cyt.http.request.call.ICall;
import com.cyt.http.response.IResponse;
import com.cyt.http.result.IResult;

public abstract class HttpScheduler {
    public abstract ICall newCall(IRequest request);

    public IResult execute(ICall call){
        IResponse response = call.execute();
        IRequest request = call.getRequest();
        IParser parser = request.getParser();
        return parser.parseResponse(request,response);
    }
}
