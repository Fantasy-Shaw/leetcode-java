package org.example.solutions.leetcode1to200;

import java.util.Arrays;

public class Solution115 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int numDistinct(String s, String t) {
            int m = s.length(), n = t.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                f[i][0] = 1;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    f[i][j] = f[i - 1][j];
                    if (s.charAt(i - 1) == t.charAt(j - 1)) {
                        f[i][j] = (f[i][j] + f[i - 1][j - 1]) % mod;
                    }
                }
            }
            return f[m][n];
        }
    }

    class Solution1 {
        static final int mod = (int) 1e9 + 7;

        public int numDistinct(String s, String t) {
            int m = s.length(), n = s.length();
            int[][] memo = new int[m][n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            return dfs(s, t, 0, 0, memo);
        }

        private int dfs(String s, String t, int x, int y, int[][] memo) {
            if (y == t.length()) {
                return 1;
            }
            if (x == s.length()) {
                return 0;
            }
            if (memo[x][y] != -1) {
                return memo[x][y];
            }
            int ans = 0;
            for (int i = x; i < s.length(); i++) {
                if (s.charAt(i) == t.charAt(y)) {
                    ans += dfs(s, t, i + 1, y + 1, memo);
                    ans %= mod;
                }
            }
            memo[x][y] = ans;
            return ans;
        }
    }
}