package org.example.solutions;


class Solution2466 {
    private final int mod = (int) (1e9 + 7);

    public int countGoodStrings(int low, int high, int zero, int one) {
        int ans = 0;
        int[] dp = new int[high + 1];
        dp[0] = 1;
        for (int i = 1; i <= high; i++) {
            if (i >= one) {
                dp[i] = (dp[i] + dp[i - one]) % mod;
            }
            if (i >= zero) {
                dp[i] = (dp[i] + dp[i - zero]) % mod;
            }
            if (i >= low) {
                ans = (ans + dp[i]) % mod;
            }
        }
        return ans;
    }
}