package com.cyt.task;

import java.util.concurrent.ThreadFactory;

public class TaskThreadFactory implements ThreadFactory {

    @Override
    public Thread newThread(Runnable runnable) {
        return new Thread(runnable,"task_thread_pool");
    }
}
