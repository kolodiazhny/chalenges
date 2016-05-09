package com.kolodiazhny.client;


public interface Clientable {
    String getMainScreen();
    String getTaskInfo(int taskId);
    String getCurrentTaskInfo();
    String startTask(int taskId);
    String resolveTask(int taskId);
    String finishCurrentTask();
}
