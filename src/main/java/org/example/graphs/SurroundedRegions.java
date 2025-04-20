package org.example.graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O'}
        };

        DFSSolution dfsSolution = new DFSSolution();
        dfsSolution.solve(board);

        System.out.println(Arrays.deepToString(board));

        char[][] board2 = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'O'}
        };
        BFSSSolution bfssSolution = new BFSSSolution();
        bfssSolution.solve(board2);
        System.out.println(Arrays.deepToString(board2));
    }
}

class DFSSolution {
    private int ROWS, COLS;

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            if (board[r][0] == 'O') {
                capture(board, r, 0);
            }
            if (board[r][COLS - 1] == 'O') {
                capture(board, r, COLS - 1);
            }
        }

        for (int c = 0; c < COLS; c++) {
            if (board[0][c] == 'O') {
                capture(board, 0, c);
            }
            if (board[ROWS - 1][c] == 'O') {
                capture(board, ROWS - 1, c);
            }
        }

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }


    }

    private void capture(char[][] board, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != 'O') return;
        board[r][c] = 'T';
        capture(board, r + 1, c);
        capture(board, r - 1, c);
        capture(board, r, c + 1);
        capture(board, r, c - 1);
    }
}

class BFSSSolution {
    private int ROWS, COLS;
    private int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        ROWS = board.length;
        COLS = board[0].length;

        capture(board);
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                } else if (board[r][c] == 'T') {
                    board[r][c] = 'O';
                }
            }
        }
    }

    private void capture(char[][] board) {
        Queue<int[]> q = new LinkedList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (r == 0 || c == 0 || r == ROWS - 1 || c == COLS - 1 && board[r][c] == 'O') {
                    q.offer(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty()) {
            int node[] = q.poll();
            int row = node[0], col = node[1];
            if(board[row][col] == 'O'){
                board[row][col] = 'T';
                for (int[] dir : directions) {
                    int nr = row + dir[0], nc = col + dir[1];
                    if(nr >= 0 && nc >=0 && nr < ROWS && nc < COLS && board[nr][nc] == 'O'){
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
        }
    }
}
