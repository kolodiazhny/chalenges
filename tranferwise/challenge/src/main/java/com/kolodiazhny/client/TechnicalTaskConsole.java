package com.kolodiazhny.client;

import com.kolodiazhny.model.Currency;

public class TechnicalTaskConsole {
    public static void main(String[] args) {
        TransferWiseClient client = new TransferWiseClient();
//        System.out.println(client.getMainScreen());
//        System.out.println(client.getCurrentTaskInfo());
//        System.out.println(client.getTaskInfo(1));

//        //----------- Task 1----
//        System.out.println(client.startTask(1));
//        System.out.println(client.getCurrentTaskInfo());
//        System.out.println(client.resolveTask(1));
//        System.out.println(client.finishCurrentTask());

        //----------- Task 2----
        //System.out.println(client.startTask(2));
//        System.out.println(client.getCurrentTaskInfo());
//        System.out.println(client.resolveTask(2));
//        System.out.println(client.finishCurrentTask());

        //----------- Task 3---
        System.out.println(client.startTask(3));
        System.out.println(client.getCurrentTaskInfo());
        System.out.println(client.getInfo());

    }
}
