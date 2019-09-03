package com.cyt.http.request;

import com.cyt.http.annotation.RequestMethod;
import com.cyt.http.request.host.IHost;

import java.util.Map;

public class LfRequest implements IRequest {

    protected String path;

    protected Map<String, Object> params;

    protected IHost host;
    @RequestMethod
    protected int requestMethod;

    @Override
    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    @Override
    public Map<String, Object> getParams() {
        return params;
    }

    @Override
    public int getRequestMethod() {
        return requestMethod;
    }

    @Override
    public IHost getHost() {
        return host;
    }

    @Override
    public String getPath() {
        return path;
    }
}
