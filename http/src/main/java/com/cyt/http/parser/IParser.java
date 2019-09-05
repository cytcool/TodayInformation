package com.cyt.http.parser;

import com.cyt.http.request.IRequest;
import com.cyt.http.response.IResponse;
import com.cyt.http.result.IResult;

public interface IParser {
    IResult parseResponse(IRequest request, IResponse response);
}
