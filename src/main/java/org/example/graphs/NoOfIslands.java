package org.example.graphs;

import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;

public class NoOfIslands {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        DFS dfs = new DFS();
        System.out.println(dfs.numIslands(grid));

        char[][] grid2 = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        BFS bfs = new BFS();
        System.out.println(bfs.numIslands(grid2));
    }
}


// Time complexity: O(m*n)
// Space complexity: O(m*n)
//Where m is the number of rows and n is the number of columns in the grid.
class DFS {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int islands = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; //visited
        for (int[] direction : directions) {
            dfs(grid, row + direction[0], col + direction[1]);
        }
    }
}

// Time complexity: O(m*n)
// Space complexity: O(m*n)
//Where m is the number of rows and n is the number of columns in the grid.
class BFS {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int rows = grid.length;
        int cols = grid[0].length;

        int islands = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1') {
                    bfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col] = '0';

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int r = node[0], c = node[1];
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nc >= 0 && nr < grid.length && nc < grid[0].length && grid[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    grid[nr][nc] = '0';
                }
            }
        }
    }
}
