package com.kolodiazhny.tasks;


import java.util.ArrayList;

public class Task2 {
    public static final String TASK2_PARAMETER = "/survivor";

    public long getResult() {
        return remain(100);
    }

    public String getParameter() {
        return TASK2_PARAMETER;
    }

    public static long remain(long total) {
        // fill array list
        ArrayList<Integer> chairs = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            chairs.add(i + 1);
        }

        // removing all but one elements
        int indexOfChair = 0;
        int count = 1;
        while (chairs.size() > 1) {
            chairs.remove(indexOfChair);
            indexOfChair += count;// skip the count number of chairs
            count++; //increase the number of chairs to skip by 1
            indexOfChair %= chairs.size();// loop to beginning if necessary
        }
        return chairs.get(0);
    }
}
