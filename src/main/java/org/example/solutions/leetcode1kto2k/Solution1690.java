package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1690 {
    class Solution {
        public int stoneGameVII(int[] stones) {
            int n = stones.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + stones[i];
            }
            int[][] dp = new int[n][n];
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    dp[i][j] = Math.max(
                            sum[j + 1] - sum[i + 1] - dp[i + 1][j],
                            sum[j] - sum[i] - dp[i][j - 1]
                    );
                }
            }
            return dp[0][n - 1];
        }
    }

    class Solution1 {
        public int stoneGameVII(int[] stones) {
            int n = stones.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + stones[i];
            }
            int[][] memo = new int[n][n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(0, n - 1, sum, memo);
        }

        private int dfs(int i, int j, int[] sum, int[][] memo) {
            if (i == j) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int first = sum[j + 1] - sum[i + 1] - dfs(i + 1, j, sum, memo);
            int second = sum[j] - sum[i] - dfs(i, j - 1, sum, memo);
            int ans = Math.max(first, second);
            memo[i][j] = ans;
            return ans;
        }
    }
}