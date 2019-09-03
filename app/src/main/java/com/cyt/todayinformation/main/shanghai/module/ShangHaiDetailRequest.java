package com.cyt.todayinformation.main.shanghai.module;

import com.cyt.http.request.IRequest;
import com.cyt.http.annotation.RequestMethod;
import com.cyt.todayinformation.base.JHRequest;

public interface ShangHaiDetailRequest {
    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get);
}
