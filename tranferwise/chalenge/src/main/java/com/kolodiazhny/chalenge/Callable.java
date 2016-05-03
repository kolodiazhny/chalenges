package com.kolodiazhny.chalenge;


public interface Callable {
    String getTaskInfo(int taskId);

    String getCurrentTaskInfo();

    void startTask(int taskId);
}
