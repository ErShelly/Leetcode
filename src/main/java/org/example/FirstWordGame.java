package org.example;

import java.util.Scanner;

public class FirstWordGame {

    // Helper method to calculate points for a given string
    private static int calculatePoints(String str, int N) {
        int points = 0;
        for (int i = 0; i < N; i++) {
            int position = str.charAt(i) - 'a' + 1; // Alphabetical position
            points += position * (N - i); // Weighted sum
        }
        return points;
    }

    // Main solve method
    public static int solve(int N, int K, String S) {
        int minPoints = Integer.MAX_VALUE;

        // Try all possible rotations of the first K characters
        String currentString = S;
        // Add the original string to the list of possibilities
        minPoints = Math.min(minPoints, calculatePoints(currentString, N));

        // Perform the rotation once, since K=1 allows only one operation
        for (int i = 0; i < K; i++) {
            // Perform rotation: remove the first character and append it to the end
            char firstChar = currentString.charAt(0);
            currentString = currentString.substring(1) + firstChar;

            // Calculate points for the rotated string
            minPoints = Math.min(minPoints, calculatePoints(currentString, N));
        }

        return minPoints;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input format
        int N = scanner.nextInt(); // Total length of string
        int K = scanner.nextInt(); // Maximum value of K
        String S = scanner.next(); // Input string

        // Solve and output the result
        int result = solve(N, K, S);
        System.out.println(result);

        scanner.close();
    }
}
