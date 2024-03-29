package com.cyt.todayinformation.main.shanghai.module;

import com.cyt.http.request.IRequest;
import com.cyt.http.annotation.RequestMethod;
import com.cyt.todayinformation.base.JHRequest;
import com.cyt.todayinformation.main.shanghai.dto.ShanghaiDetailBean;

public interface ShangHaiDetailRequest {
    IRequest xiaoHuaRequest = JHRequest.sendHttp("/joke/content/list.php", RequestMethod.Get, ShanghaiDetailBean.class);
}
