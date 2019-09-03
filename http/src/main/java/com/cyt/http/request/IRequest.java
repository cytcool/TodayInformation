package com.cyt.http.request;

import com.cyt.http.request.host.IHost;

import java.util.Map;

public interface IRequest {
    void setParams(Map<String, Object> params);

    Map<String,Object> getParams();

    int getRequestMethod();

    IHost getHost();

    String getPath();
}
