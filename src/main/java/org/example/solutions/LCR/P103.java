package org.example.solutions.LCR;

import java.util.Arrays;

public class P103 {
    class Solution {
        static final int inf = Integer.MAX_VALUE / 2;

        public int coinChange(int[] coins, int amount) {
            if (amount == 0) {
                return 0;
            }
            int[] memo = new int[amount + 1];
            Arrays.fill(memo, -1);
            dfs(coins, amount, memo);
            return memo[amount] < inf ? memo[amount] : -1;
        }

        private int dfs(int[] coins, int sum, int[] memo) {
            if (memo[sum] != -1) {
                return memo[sum];
            }
            int ans = inf;
            for (int i = 0; i < coins.length; i++) {
                if (coins[i] == sum) {
                    ans = Math.min(ans, 1);
                } else if (coins[i] < sum) {
                    ans = Math.min(ans, 1 + dfs(coins, sum - coins[i], memo));
                }
            }
            memo[sum] = ans;
            return ans;
        }
    }
}