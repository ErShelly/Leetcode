import java.util.*;

public class MaximumTeamSize {
    public static int getMaximumTeamSize(List<Integer> startTime, List<Integer> endTime) {
        int n = startTime.size();
        if (n == 0) return 0;

        // Step 1: Create events
        List<int[]> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            events.add(new int[]{startTime.get(i), 1});  // Employee starts
            events.add(new int[]{endTime.get(i), -1});   // Employee leaves
        }

        // Step 2: Sort events correctly
        events.sort((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // Sort by time
            return Integer.compare(b[1], a[1]); // Prioritize -1 (leave) over +1 (start)
        });

        // Step 3: Sweep Line Algorithm
        int maxTeamSize = 0, currentTeamSize = 0;
        for (int[] event : events) {
            currentTeamSize += event[1]; // Increment for +1 (start), decrement for -1 (end)
            maxTeamSize = Math.max(maxTeamSize, currentTeamSize);
        }

        return maxTeamSize;
    }

    public static void main(String[] args) {
        List<Integer> startTime = Arrays.asList(2, 5, 6, 8);
        List<Integer> endTime = Arrays.asList(5, 6, 10, 9);

        System.out.println("Maximum Team Size: " + getMaximumTeamSize(startTime, endTime)); // Expected: 3
    }
}
