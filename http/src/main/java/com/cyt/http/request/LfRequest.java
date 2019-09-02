package com.cyt.http.request;

import com.cyt.http.annotation.RequestMethod;
import com.cyt.http.request.host.IHost;

public class LfRequest implements IRequest {

    protected IHost host;
    @RequestMethod
    protected int requestMethod;
}
