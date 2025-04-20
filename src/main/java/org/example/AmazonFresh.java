package org.example;

import java.util.*;

import java.util.*;

public class AmazonFresh {

        public static int maxProductSum(int[] arr) {
            int maxSum = 0;
            int n = arr.length;

            for (int i = 0; i < n; i++) {
                int currentSum = 0;
                for (int j = i; j < n; j++) {
                    // The product picked is the (j - i + 1)th position in the subarray
                    int product = (j - i + 1); // 1-based position within the subarray
                    currentSum += product;
                    if (currentSum > maxSum) {
                        maxSum = currentSum;
                    }
                }
            }

            return maxSum;
        }

        public static void main(String[] args) {
            int[] arr = {2, 9, 4, 7, 5, 2};
            System.out.println(maxProductSum(arr)); // Output: 16
        }
    }
