package org.example.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class IncludeEachQuery {
    public static void main(String[] args){
        int[][] intervals = {{1,4},{2,4}, {3,6},{4,4}};
        int[] queries = {2,3,4,5};
        System.out.println(Arrays.toString(minInterval(intervals, queries))); // {3,3,1,4}
    }
    public static int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n= queries.length;
        int[][] queryIndexes = new int[n][2];
        for(int i=0;i<n; i++){
            queryIndexes[i][0] = queries[i];
            queryIndexes[i][1] = i;
        }

        Arrays.sort(queryIndexes, (a,b) -> Integer.compare(a[0], b[0]));

        int[] res = new int[n];
        int i=0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b)->(a[0] != b[0]) ? a[0]-b[0] : a[1]-b[1]);

        for(int[] query: queryIndexes){
            int q = query[0];
            int idx = query[1];

            while(i<intervals.length && intervals[i][0] <= q){
                int len = intervals[i][1] - intervals[i][0] + 1;
                minHeap.offer(new int[]{len, intervals[i][1]});
                i++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1]< q){
                minHeap.poll();
            }

            res[idx] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }

        return res;
    }
}
