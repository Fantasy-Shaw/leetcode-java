package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3122 {
    class Solution {
        int m, n;

        public int minimumOperations(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            int[][] cnt = new int[n][10];
            for (var row : grid) {
                for (int i = 0; i < n; i++) {
                    cnt[i][row[i]]++;
                }
            }
            int[][] memo = new int[n][11];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(cnt, 10, 0, memo);
        }

        private int dfs(int[][] cnt, int pre, int l, int[][] memo) {
            if (l >= n) {
                return 0;
            }
            if (memo[l][pre] != -1) {
                return memo[l][pre];
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i <= 9; i++) {
                if (i == pre) continue;
                int cur = m - cnt[l][i] + dfs(cnt, i, l + 1, memo);
                ans = Math.min(ans, cur);
            }
            memo[l][pre] = ans;
            return ans;
        }
    }
}