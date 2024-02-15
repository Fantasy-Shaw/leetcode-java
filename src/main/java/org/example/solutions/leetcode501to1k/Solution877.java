package org.example.solutions.leetcode501to1k;

public class Solution877 {
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n + 2][n + 2];
            for (int l = 1; l <= n; l++) {
                for (int i = 1; i + l - 1 <= n; i++) {
                    int j = i + l - 1;
                    dp[i][j] = Math.max(piles[i - 1] - dp[i + 1][j], piles[j - 1] - dp[i][j - 1]);
                }
            }
            return dp[1][n] > 0;
        }
    }

    class Solution1 {
        public boolean stoneGame(int[] piles) {
            return true;
        }
    }
}