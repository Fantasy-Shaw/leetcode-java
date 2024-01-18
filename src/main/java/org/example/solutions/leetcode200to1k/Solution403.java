package org.example.solutions.leetcode200to1k;

public class Solution403 {
    class Solution {
        public boolean canCross(int[] stones) {
            int n = stones.length;
            if (stones[1] != 1) return false;
            boolean[][] dp = new boolean[n][n];
            dp[1][1] = true;
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    int k = stones[i] - stones[j];
                    if (k <= j + 1) {
                        dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                    }
                }
            }
            for (int i = 1; i < n; i++) {
                if (dp[n - 1][i]) return true;
            }
            return false;
        }
    }
}