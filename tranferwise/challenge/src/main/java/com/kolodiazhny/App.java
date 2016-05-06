package com.kolodiazhny;

public class App {
    public static void main(String[] args) {
        System.out.println("Task #1");
        System.out.println("Output from Server .... \n");
        TransferWiseClient client = new TransferWiseClient();
        System.out.println(client.getMainScreen());
        System.out.println(client.getCurrentTaskInfo());
        System.out.println(client.getTaskInfo(1));
    }
}
