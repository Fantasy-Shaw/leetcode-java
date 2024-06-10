package org.example.solutions.leetcode201to500;

public class Solution419 {
    class Solution {
        public int countBattleships(char[][] board) {
            int ans = 0;
            int m = board.length, n = board[0].length;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'X') {
                        dfs(board, i, j);
                        ans++;
                    }
                }
            }
            return ans;
        }

        private void dfs(char[][] board, int x, int y) {
            if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
            if (board[x][y] == '.') return;
            board[x][y] = '.';
            dfs(board, x - 1, y);
            dfs(board, x + 1, y);
            dfs(board, x, y - 1);
            dfs(board, x, y + 1);
        }
    }
}