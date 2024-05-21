package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3148 {
    class Solution {
        int m, n;
        int[][] g;

        public int maxScore(List<List<Integer>> grid) {
            m = grid.size();
            n = grid.getFirst().size();
            g = new int[m][];
            for (int i = 0; i < m; i++) {
                g[i] = grid.get(i).stream().mapToInt(Integer::intValue).toArray();
            }
            Integer[][] memo = new Integer[m][n];
            int ans = Integer.MIN_VALUE;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans = Math.max(ans, dfs(i, j, memo));
                }
            }
            return ans;
        }

        private int dfs(int i, int j, Integer[][] memo) {
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            int ans = Integer.MIN_VALUE / 2;
            for (int x = 1; i + x < m; x++) {
                int delta = g[i + x][j] - g[i][j];
                ans = Math.max(ans, Math.max(delta, delta + dfs(i + x, j, memo)));
            }
            for (int x = 1; j + x < n; x++) {
                int delta = g[i][j + x] - g[i][j];
                ans = Math.max(ans, Math.max(delta, delta + dfs(i, j + x, memo)));
            }
            return memo[i][j] = ans;
        }
    }
}