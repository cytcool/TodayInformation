package com.cyt.task.tools;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtil {

    // 主线程的Handler
    private final static Handler MAIN = new Handler(Looper.getMainLooper());

    // 当前设备的CPU数量
    public static int CPU_NUM = Runtime.getRuntime().availableProcessors();

    public static void postMainThread(Runnable runnable){
        MAIN.post(new Runnable() {
            @Override
            public void run() {
                try{

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}
