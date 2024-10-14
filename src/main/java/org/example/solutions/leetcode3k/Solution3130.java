package org.example.solutions.leetcode3k;

import java.util.Arrays;

class Solution3130 {
    class Solution {
        static final int MOD = 1_000_000_007;

        int limit;

        public int numberOfStableArrays(int zero, int one, int limit) {
            int[][][] memo = new int[zero + 1][one + 1][2];
            for (var x : memo) {
                for (var y : x) {
                    Arrays.fill(y, -1);
                }
            }
            this.limit = limit;
            return (dfs(zero, one, 0, memo) + dfs(zero, one, 1, memo)) % MOD;
        }

        private int dfs(int zero, int one, int cur, int[][][] memo) {
            if (zero == 0) {
                return cur == 1 && one <= limit ? 1 : 0;
            }
            if (one == 0) {
                return cur == 0 && zero <= limit ? 1 : 0;
            }
            if (memo[zero][one][cur] != -1) {
                return memo[zero][one][cur];
            }
            int ans = 0;
            if (cur == 0) {
                ans = (ans + dfs(zero - 1, one, 0, memo)) % MOD;
                ans = (ans + dfs(zero - 1, one, 1, memo)) % MOD;
                if (zero > limit) {
                    ans = (ans - dfs(zero - limit - 1, one, 1, memo) + MOD) % MOD;
                }
            } else {
                ans = (ans + dfs(zero, one - 1, 0, memo)) % MOD;
                ans = (ans + dfs(zero, one - 1, 1, memo)) % MOD;
                if (one > limit) {
                    ans = (ans - dfs(zero, one - limit - 1, 0, memo) + MOD) % MOD;
                }
            }
            return memo[zero][one][cur] = ans;
        }
    }
}