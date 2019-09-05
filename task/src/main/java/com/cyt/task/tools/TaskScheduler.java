package com.cyt.task.tools;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import com.cyt.task.AsyncTaskInstance;
import com.cyt.task.PriorityThreadPoolExecutor;
import com.cyt.task.TaskThreadFactory;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class TaskScheduler {

    interface ITaskScheduler{
        int SUBMIT_TASK = 0;
    }

    private static TaskScheduler instance;
    private Handler handler;
    private final static int COREPOOLSIZE = ThreadUtil.CPU_NUM + 1;
    private final static int MAXIMUMPOOLSIZE = COREPOOLSIZE * 3;
    private final static int KEEPALIVETIME = 1;

    private final PriorityThreadPoolExecutor executor;

    private TaskScheduler(){
        // 用于消息调度的线程
        HandlerThread handlerThread = new HandlerThread("task-thread");
        handlerThread.start();
        this.handler = new Handler(handlerThread.getLooper(), new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                switch (message.what){
                    case ITaskScheduler.SUBMIT_TASK:
                        doSubmitTask((AsyncTaskInstance) message.obj);
                        break;
                }
                return false;
            }
        });
        // 创建一个线程池
        BlockingQueue<Runnable> poolQueue = new LinkedBlockingQueue<>();
        this.executor = new PriorityThreadPoolExecutor(COREPOOLSIZE,MAXIMUMPOOLSIZE,KEEPALIVETIME, TimeUnit.MINUTES,poolQueue,new TaskThreadFactory());
    }

    private void doSubmitTask(AsyncTaskInstance taskInstance) {
        executor.submit(taskInstance);
    }

    public static TaskScheduler getInstance(){
        if (instance == null){
            instance = new TaskScheduler();
        }
        return instance;
    }

    public void submit(AsyncTaskInstance instance){
        handler.sendMessage(handler.obtainMessage(ITaskScheduler.SUBMIT_TASK,instance));
    }
}
