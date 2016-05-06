package com.kolodiazhny;

public class TechnicalTask {
    public static void main(String[] args) {
        TransferWiseClient client = new TransferWiseClient();
        System.out.println(client.getMainScreen());
        System.out.println(client.getCurrentTaskInfo());
        System.out.println(client.getTaskInfo(1));

        System.out.println(client.startTask(1));
        System.out.println(client.getCurrentTaskInfo());
        //----------- Task 1----
        System.out.println(client.resolveTask(1));
        System.out.println(client.finishCurrentTask());
    }
}
