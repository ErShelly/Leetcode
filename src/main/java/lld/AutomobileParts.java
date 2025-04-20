package lld;

public class AutomobileParts {

    public static int maxProfit(int[] uniqueIds, int[] profits, int N) {
        if (N == 0) {
            return 0;
        }

        // dp[i] = max profit up to the i-th part
        int[] dp = new int[N];
        dp[0] = profits[0]; // Base case: First part's profit

        for (int i = 1; i < N; i++) {
            // Option 1: Don't take the current part → dp[i] = dp[i-1]
            int profitIfNotTaken = dp[i - 1];

            // Option 2: Take the current part
            int profitIfTaken = profits[i];

            // If current ID is different from previous, add dp[i-1]
            if (uniqueIds[i] != uniqueIds[i - 1]) {
                profitIfTaken += dp[i - 1];
            } else if (i >= 2) {
                // If same as previous, skip the previous part → add dp[i-2]
                profitIfTaken += dp[i - 2];
            }

            // Take the maximum of both options
            dp[i] = Math.max(profitIfTaken, profitIfNotTaken);
        }

        return dp[N - 1];
    }

    public static void main(String[] args) {
        int[] uniqueIds1 = {4, 6, 3, 3, 4};
        int[] profits1 = {-1, 10, 10, 15, -5};
        System.out.println("Maximum profit: " + maxProfit(uniqueIds1, profits1, profits1.length)); // 25

        int[] uniqueIds2 = {1, 2, 1};
        int[] profits2 = {10, 20, 30};
        System.out.println("Maximum profit: " + maxProfit(uniqueIds2, profits2, profits2.length)); // 60
    }
}