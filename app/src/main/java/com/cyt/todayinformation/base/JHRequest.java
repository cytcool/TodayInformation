package com.cyt.todayinformation.base;

import com.cyt.http.parser.DefaultResultParser;
import com.cyt.http.request.IRequest;
import com.cyt.http.annotation.RequestMethod;
import com.cyt.http.request.LfRequest;

import java.lang.reflect.Type;

public class JHRequest extends LfRequest {

    public static IRequest sendHttp(String path, @RequestMethod int requestMethod, Type type) {
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.path = path;
        request.type = type;
        request.requestMethod = requestMethod;
        request.resultParser = DefaultResultParser.getInstance();
        return request;
    }
}
