package com.cyt.http.request.call;

import com.cyt.http.request.IRequest;
import com.cyt.http.response.IResponse;

public interface ICall {
    IResponse execute();

    IRequest getRequest();
}

