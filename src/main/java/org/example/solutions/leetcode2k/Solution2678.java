package org.example.solutions.leetcode2k;

import java.util.Arrays;

public class Solution2678 {
    class Solution {
        static final int[][] dirs = {{-1, 1}, {0, 1}, {1, 1}};
        int[][] grid;

        public int maxMoves(int[][] grid) {
            this.grid = grid;
            int m = grid.length, n = grid[0].length;
            int[][] memo = new int[m][n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                ans = Math.max(ans, dfs(i, 0, memo));
            }
            return ans;
        }

        private int dfs(int x, int y, int[][] memo) {
            if (memo[x][y] != -1) {
                return memo[x][y];
            }
            int ans = 0;
            for (var dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (inBound(nx, ny) && grid[nx][ny] > grid[x][y]) {
                    ans = Math.max(ans, 1 + dfs(nx, ny, memo));
                }
            }
            memo[x][y] = ans;
            return ans;
        }

        private boolean inBound(int x, int y) {
            return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
        }
    }
}