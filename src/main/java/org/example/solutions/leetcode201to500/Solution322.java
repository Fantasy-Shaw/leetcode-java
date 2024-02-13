package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution322 {
    class Solution {
        static int inf = Integer.MAX_VALUE / 2;

        public int coinChange(int[] coins, int amount) {
            int n = coins.length;
            int[][] dp = new int[n + 1][amount + 1];
            for (int[] ints : dp) {
                Arrays.fill(ints, inf);
            }
            dp[0][0] = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= amount; j++) {
                    if (j < coins[i]) dp[i + 1][j] = dp[i][j];
                    else dp[i + 1][j] = Math.min(dp[i][j], dp[i + 1][j - coins[i]] + 1);
                }
            }
            int ans = dp[n][amount];
            return ans < inf ? ans : -1;
        }
    }
}