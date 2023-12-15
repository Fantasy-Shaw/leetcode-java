package org.example.solutions;

class Solution91 {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        char[] cs = (" " + s).toCharArray();
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int a = cs[i] - '0';
            int b = (cs[i - 1] - '0') * 10 + a;
            if (1 <= a && a <= 9) {
                dp[i] = dp[i - 1];
            }
            if (10 <= b && b <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
