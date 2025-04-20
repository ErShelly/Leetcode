package org.example.intervals;

public class LectureComplexity {
    public static void main(String[] args) {
        int[] lectures = {10, 20, 30, 40, 50};
        int days = 2;

        System.out.println(minimizeSumOfMaxComplexities(lectures, days));
    }

    // Helper function to calculate the sum of maximum complexities for a given split
    private static int calculateSum(int[] lectures, int[] splitIndices, int days) {
        int sum = 0;
        int start = 0;

        for (int i = 0; i < days; i++) {
            int end = (i == days - 1) ? lectures.length : splitIndices[i];
            int max = 0;

            // Calculate the maximum complexity for the current day
            for (int j = start; j < end; j++) {
                max += lectures[j];
            }

            sum += max; // Add the maximum complexity for this day
            start = end;
        }

        return sum;
    }

    // Recursive function to explore all possible splits
    private static void exploreSplits(int[] lectures, int[] splitIndices, int currentDay, int start, int days, int[] result) {
        if (currentDay == days - 1) {
            // Base case: All splits are done, calculate the sum
            int sum = calculateSum(lectures, splitIndices, days);
            if (sum < result[0]) {
                result[0] = sum; // Update the minimum sum
            }
            return;
        }

        // Try all possible split positions for the current day
        for (int i = start; i < lectures.length; i++) {
            splitIndices[currentDay] = i + 1; // Record the split position
            exploreSplits(lectures, splitIndices, currentDay + 1, i + 1, days, result);
        }
    }

    // Main function to find the minimum sum of maximum complexities
    public static int minimizeSumOfMaxComplexities(int[] lectures, int days) {
        if (lectures == null || lectures.length == 0 || days <= 0 || days > lectures.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        int[] result = { Integer.MAX_VALUE }; // Store the minimum sum
        int[] splitIndices = new int[days - 1]; // Store the split positions

        exploreSplits(lectures, splitIndices, 0, 0, days, result);

        return result[0];
    }

}
