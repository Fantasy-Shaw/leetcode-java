package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution741 {
    class Solution {
        private int n;

        public int cherryPickup(int[][] grid) {
            n = grid.length;
            int[][][] memo = new int[2 * n - 1][n][n];
            for (var t1 : memo) {
                for (var t2 : t1) {
                    Arrays.fill(t2, -1);
                }
            }
            return Math.max(dfs(grid, 2 * n - 2, n - 1, n - 1, memo), 0);
        }

        private int dfs(int[][] grid, int step, int j, int y, int[][][] memo) {
            int i = step - j, x = step - y;
            if (!inBound(x, y) || !inBound(i, j) || grid[x][y] == -1 || grid[i][j] == -1) {
                return Integer.MIN_VALUE;
            }
            if (step == 0) {
                return grid[0][0];
            }
            if (memo[step][j][y] != -1) {
                return memo[step][j][y];
            }
            int ans = Math.max(
                    Math.max(dfs(grid, step - 1, j, y, memo), dfs(grid, step - 1, j, y - 1, memo)),
                    Math.max(dfs(grid, step - 1, j - 1, y, memo), dfs(grid, step - 1, j - 1, y - 1, memo))
            ) + grid[i][j] + (j == y ? 0 : grid[x][y]);
            return memo[step][j][y] = ans;
        }

        private boolean inBound(int x, int y) {
            return x >= 0 && x < n && y >= 0 && y < n;
        }
    }
}