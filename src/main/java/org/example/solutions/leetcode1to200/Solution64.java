package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution64 {
    class Solution {
        int m, n;

        public int minPathSum(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int[][] memo = new int[m][n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(grid, 0, 0, memo);
        }

        private int dfs(int[][] grid, int i, int j, int[][] memo) {
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (i == m - 1 && j == n - 1) {
                return grid[i][j];
            }
            memo[i][j] = grid[i][j] + Math.min(
                    i + 1 < m ? dfs(grid, i + 1, j, memo) : Integer.MAX_VALUE,
                    j + 1 < n ? dfs(grid, i, j + 1, memo) : Integer.MAX_VALUE
            );
            return memo[i][j];
        }

        private boolean inBound(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
}