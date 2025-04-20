package org.example.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumEventsAttended {

    //Time Complexity: O(nlogn)
    //Space complexity: O(n)
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0])); // Sort by start day
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // Min-heap for event end days

        int maxDays = 0;
        for (int[] event : events) {
            maxDays = Math.max(maxDays, event[1]); // Find the last possible day
        }

        int eventIndex = 0, attended = 0;
        for (int day = 1; day <= maxDays; day++) {
            // Add all events that start on this day
            while (eventIndex < events.length && events[eventIndex][0] == day) {
                minHeap.offer(events[eventIndex][1]); // Push event's end day into heap
                eventIndex++;
            }

            // Remove expired events
            while (!minHeap.isEmpty() && minHeap.peek() < day) {
                minHeap.poll();
            }

            // Attend the event that ends the earliest
            if (!minHeap.isEmpty()) {
                minHeap.poll(); // Attend this event
                attended++;
            }
        }

        return attended;
    }

    public static void main(String[] args) {
        MaximumEventsAttended solution = new MaximumEventsAttended();

        // Test cases
//        int[][] events1 = {{1, 2}, {2, 3}, {3, 4}};
//        System.out.println(solution.maxEvents(events1)); // Output: 3

//        int[][] events2 = {{1, 2}, {2, 3}, {3, 4}, {1, 2}};
//        System.out.println(solution.maxEvents(events2)); // Output: 4

        int[][] events3 = {{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}};
        System.out.println(solution.maxEvents(events3)); // Output: 4
    }
}
