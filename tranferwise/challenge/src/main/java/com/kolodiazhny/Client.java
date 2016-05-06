package com.kolodiazhny;


public interface Client {
    String getMainScreen();

    String getTaskInfo(int taskId);

    String getCurrentTaskInfo();

    void startTask(int taskId);
}
