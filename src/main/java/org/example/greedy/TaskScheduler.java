package org.example.greedy;

import java.util.Arrays;

public class TaskScheduler {
    public static int leastInterval1(char[] tasks, int n) {
        int[] charMap = new int[26];
        for(char c: tasks){
            charMap[c - 'A']++;
        }

        Arrays.sort(charMap);
        int maxVal =  charMap[25];
        int idle = (maxVal - 1) * n;

        for(int i=24; i>=0; i--){
            idle -= Math.min(maxVal-1, charMap[i]);
        }

        return Math.max(0,idle) + tasks.length;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        int maxf = Arrays.stream(count).max().getAsInt();
        int maxCount = 0;
        for (int i : count) {
            if (i == maxf) {
                maxCount++;
            }
        }

        int time = (maxf - 1) * (n + 1) + maxCount;
        return Math.max(tasks.length, time);
    }
}
