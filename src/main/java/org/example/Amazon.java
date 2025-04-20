package org.example;

import java.util.*;

public class Amazon {

    public static List<Integer> findOptimalPermutation(List<Integer> data) {
        int n = data.size();
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            indices.add(i + 1); // Indices are from 1 to n
        }

        // Sort indices based on the data values in ascending order
        // If two values are equal, sort their indices in ascending order
        indices.sort((a, b) -> {
            int valueA = data.get(a - 1);
            int valueB = data.get(b - 1);
            if (valueA == valueB) {
                return a - b; // Lexicographical order for equal values
            } else {
                return valueA - valueB; // Ascending order for values
            }
        });

        // The sorted indices list is the permutation
        return indices;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            data.add(scanner.nextInt());
        }
        scanner.close();

        List<Integer> optimalPermutation = findOptimalPermutation(data);
        for (int num : optimalPermutation) {
            System.out.println(num);
        }
    }
}
