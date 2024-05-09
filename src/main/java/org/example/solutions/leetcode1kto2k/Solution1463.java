package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1463 {
    class Solution {
        static final int[] delta = {-1, 0, 1};
        private int m, n;

        public int cherryPickup(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int[][][] memo = new int[m][n][n];
            for (var t1 : memo) {
                for (var t2 : t1) {
                    Arrays.fill(t2, -1);
                }
            }
            return dfs(grid, 0, 0, n - 1, memo);
        }

        private int dfs(int[][] grid, int i, int j, int k, int[][][] memo) {
            if (i >= m || j < 0 || j >= n || k < 0 || k >= n) return 0;
            if (memo[i][j][k] != -1) return memo[i][j][k];
            int ans = Integer.MIN_VALUE;
            for (int dj : delta) {
                for (int dk : delta) {
                    ans = Math.max(ans, dfs(grid, i + 1, j + dj, k + dk, memo));
                }
            }
            ans += grid[i][j];
            ans += (j == k) ? 0 : grid[i][k];
            memo[i][j][k] = ans;
            return ans;
        }
    }
}