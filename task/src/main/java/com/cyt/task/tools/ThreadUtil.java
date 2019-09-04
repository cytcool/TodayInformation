package com.cyt.task.tools;

import android.os.Handler;
import android.os.Looper;

public class ThreadUtil {

    private final static Handler MAIN = new Handler(Looper.getMainLooper());

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
