package com.cyt.task.tools;

public class TaskScheduler {

    private static TaskScheduler instance;

    private TaskScheduler(){

    }

    public static TaskScheduler getInstance(){
        if (instance == null){
            instance = new TaskScheduler();
        }
        return instance;
    }
}
