package lld;

public class SpecialSubarray {
    public static int findSmallestSpecialSubarray(int[] input1, int input2, int input3) {
        int minLength = Integer.MAX_VALUE;  // Initialize to a large value
        int currentOr = 0;  // Current bitwise OR of the window
        int left = 0;  // Left boundary of the window

        // Iterate with the right pointer
        for (int right = 0; right < input2; right++) {
            currentOr |= input1[right];

            if (input1[right] >= input3) {
                return 1; // If any element itself satisfies, return 1 immediately
            }

            while (currentOr >= input3) {
                // Update the minimum length if a valid subarray is found
                minLength = Math.min(minLength, right - left + 1);

                // Try to reduce the window size by moving the left pointer
                currentOr ^= input1[left];  // Remove the left element from the OR
                left++;
            }
        }

        // If no valid subarray is found, return -1
        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static void main(String[] args) {
        // Test case 1
        int[] input1 = {1, 2, 1, 5, 4};
        int input2 = 5;
        int input3 = 6;
        System.out.println(findSmallestSpecialSubarray(input1, input2, input3));  // Output: 3

        // Test case 2
        int[] input1_2 = {1, 2, 4, 5, 7};
        int input2_2 = 5;
        int input3_2 = 7;
        System.out.println(findSmallestSpecialSubarray(input1_2, input2_2, input3_2));  // Output: 1
    }
}
