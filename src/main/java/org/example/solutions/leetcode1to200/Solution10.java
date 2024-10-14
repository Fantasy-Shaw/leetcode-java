package org.example.solutions.leetcode1to200;

public class Solution10 {
    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 0; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (p.charAt(j - 1) == '*') {
                        dp[i][j] |= dp[i][j - 2];
                        if (f(i, j - 1, s, p)) {
                            dp[i][j] |= dp[i - 1][j];
                        }
                    } else {
                        if (f(i, j, s, p)) {
                            dp[i][j] |= dp[i - 1][j - 1];
                        }
                    }
                }
            }
            return dp[m][n];
        }

        private boolean f(int i, int j, String s, String p) {
            if (i == 0) {
                return false;
            }
            if (p.charAt(j - 1) == '.') {
                return true;
            }
            return s.charAt(i - 1) == p.charAt(j - 1);
        }
    }
}