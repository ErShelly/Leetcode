package org.example.graphs;

import java.util.*;

public class SafestPathInGrid2812 {
    public static void main(String[] args){

    }
//Time : O(n^2 logn)
//Space: O(n^2)

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int N = grid.size();
        int[][] minDist = precompute(grid, N);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a,b) -> b[0]-a[0]);
        boolean[][] visited = new boolean[N][N];

        maxHeap.offer(new int[]{minDist[0][0], 0, 0});
        visited[0][0] = true;

        while(!maxHeap.isEmpty()){
            int[] curr = maxHeap.poll();
            int dist = curr[0], r = curr[1], c = curr[2];

            if(r == N-1 && c == N-1){
                return dist;
            }

            for(int[] dir : new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}}) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if(inbound(nr, nc, N) && !visited[nr][nc]){
                    visited[nr][nc] = true;
                    int dist2 = Math.min(dist, minDist[nr][nc]);
                    maxHeap.offer(new int[]{dist2, nr, nc});
                }
            }
        }

        return 0;
    }

    private int[][] precompute(List<List<Integer>> grid, int N){
        int[][] minDist = new int[N][N];
        for(int[] row : minDist) Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();
        for(int r=0;r<N;r++){
            for(int c=0;c<N;c++){
                if(grid.get(r).get(c) == 1){
                    minDist[r][c] = 0;
                    queue.offer(new int[]{r,c,0});
                }
            }
        }

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            int r = curr[0], c=curr[1], d=curr[2];

            int[][] directions = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};

            for(int[] dir: directions){
                int nr = r + dir[0];
                int nc = c + dir[1];

                if(inbound(nr, nc, N) && minDist[nr][nc] == -1){
                    minDist[nr][nc] = d+1;
                    queue.offer(new int[]{nr, nc, d+1});
                }
            }
        }

        return minDist;
    }

    private boolean inbound(int r, int c, int N){
        return r>=0 && c>=0 && r<N && c<N;
    }
}
