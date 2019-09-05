package com.cyt.todayinformation.main.shanghai.dto;

import java.util.ArrayList;

public class ShanghaiDetailBean {
    public int error_code;
    public String reason;
    public XiaoHuaListBean result;

    public static class XiaoHuaListBean{
        public ArrayList<XiaoHuaBean> data;
    }

    public static class XiaoHuaBean{
        public String content;
        public String hashId;
        public String unixTime;
        public String updateTime;
    }
}
