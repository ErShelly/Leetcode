package org.example.graphs;

import java.util.Arrays;

public class CheapestFlights {
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(cost, n); // Temporary array for updates
            for (int[] flight : flights) {
                int u = flight[0], v = flight[1], price = flight[2];
                if (cost[u] != Integer.MAX_VALUE && cost[u] + price < temp[v]) {
                    temp[v] = cost[u] + price;
                }
            }
            cost = temp;
        }
        return cost[dst] == Integer.MAX_VALUE ? -1 : cost[dst];
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {{0,1,100}, {1,2,100}, {2,3,100}, {0,2,500}};
        int src = 0, dst = 3, K = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, K)); // Output: 300
    }
}
