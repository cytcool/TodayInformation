package com.cyt.todayinformation.base;

import com.cyt.http.request.IRequest;
import com.cyt.http.annotation.RequestMethod;
import com.cyt.http.request.LfRequest;

public class JHRequest extends LfRequest {

    public static IRequest sendHttp(String path, @RequestMethod int requestMethod) {
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.path = path;
        request.requestMethod = requestMethod;
        return request;
    }
}
