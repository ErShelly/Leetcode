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

    public static int leastInterval2(char[] tasks, int n) {
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
}
