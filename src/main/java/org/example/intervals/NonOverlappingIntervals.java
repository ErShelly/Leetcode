package org.example.intervals;

import java.util.Arrays;
import java.util.Comparator;

//435
public class NonOverlappingIntervals {
    public static void main(String[] args){
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{1,3}}));
    }

    //Greedy approach
    // Time complexity: O(nlogn)
    // Space complexity: O(1)

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null) return 0;
        //Arrays.sort(intervals, Comparator.comparingInt(a-> a[1]));
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int prevInterval = 0;
        int count = 1;
        for(int i=1; i<intervals.length; i++){
            if(intervals[i][0]>=intervals[prevInterval][1]){
                count++;
                prevInterval = i;
            }
        }

        return intervals.length - count;
    }
}
