package org.example.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfProvinces {
    public static void main(String[] args){
        int[][] matrix = {
                {1,0,0,1},
                {0,1,1,0},
                {0,1,1,1},
                {1,0,1,1}
        };

        DFS dfs = new DFS();
        System.out.println(dfs.findCircleNum(matrix));

        BFS bfs = new BFS();
        System.out.println(bfs.findCircleNum(matrix));
    }


    //O(n^2)
    //Space O(n) (recursion size)
    static class DFS {
        public int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];

            int provinces = 0;
            for(int i=0;i<n;i++){
                if(!visited[i]){
                    dfs(isConnected, visited, i);
                    provinces++;
                }
            }
            return provinces;
        }

        private void dfs(int[][] matrix, boolean[] visited, int i){
            visited[i] = true;
            for(int j=0;j<matrix.length;j++){
                if(matrix[i][j] == 1 && !visited[j]){
                    dfs(matrix, visited, j);
                }
            }
        }
    }

    //O(n^2)
    //Space O(n) (queue size)
    static class BFS{
        public int findCircleNum(int[][] connected){
            int n = connected.length;
            boolean[] visited = new boolean[n];

            int provinces=0;
            for(int i=0;i<connected.length;i++){
                if(!visited[i]){
                    bfs(connected, visited, i);
                    provinces++;
                }
            }

            return provinces;
        }

        private void bfs(int[][] connected, boolean[] visited, int i){
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);

            while (!queue.isEmpty()){
                int city = queue.poll();
                visited[city] = true;

                for(int j=0;j<connected[0].length;j++){
                    if(connected[city][j] == 1 && !visited[j]){
                        queue.add(j);
                    }
                }

            }

        }
    }
}


