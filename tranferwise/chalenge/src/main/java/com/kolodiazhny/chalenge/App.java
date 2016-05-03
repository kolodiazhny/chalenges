package com.kolodiazhny.chalenge;

public class App {
    public static void main(String[] args) {
        System.out.println("Task #1");
        System.out.println("Output from Server .... \n");
        TransferWiseNetClient client = new TransferWiseNetClient();
        System.out.println(client.getTaskInfo(1));
    }
}
