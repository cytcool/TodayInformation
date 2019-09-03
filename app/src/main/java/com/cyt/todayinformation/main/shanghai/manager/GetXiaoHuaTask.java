package com.cyt.todayinformation.main.shanghai.manager;


import android.os.AsyncTask;
import android.util.Log;

import com.cyt.todayinformation.main.shanghai.module.ShangHaiDetailHttpServer;

import java.io.IOException;

import okhttp3.Response;

public class GetXiaoHuaTask extends AsyncTask<Object, Object, Object> {


    //运行在子线程中
    @Override
    protected Object doInBackground(Object... objects) {
        Object desc = new ShangHaiDetailHttpServer().getXiaoHuaList((String) objects[0], (String) objects[1], (String) objects[2]);
        return desc;
    }

    //运行在主线程 用于 更新数据
    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        Response response = (Response) o;
        try {
            Log.e("GetXiaoHuaTask","onResponse" + response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
