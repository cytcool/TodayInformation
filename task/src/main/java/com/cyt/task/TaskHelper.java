package com.cyt.task;

import com.cyt.task.tools.TaskScheduler;

public class TaskHelper {

    public static void submitTask(ITaskBackground iTaskBackground, ITaskCallback iTaskCallback) {
        AsyncTaskInstance instance = AsyncTaskInstance.getInstance(iTaskBackground, iTaskCallback);
        // 构建线程池管理器
        TaskScheduler.getInstance().submit(instance);
    }
}
