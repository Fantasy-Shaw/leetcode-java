package org.example.solutions.leetcode201to500;

import java.util.Arrays;

public class Solution233 {
    class Solution { // 数位DP
        char[] s;
        int[][] dp;

        public int countDigitOne(int n) {
            s = String.valueOf(n).toCharArray();
            int m = s.length;
            dp = new int[m][m];
            for (var it : dp) {
                Arrays.fill(it, -1);
            }
            return f(0, 0, true);
        }

        private int f(int i, int cnt1, boolean isLimit) {
            if (i == s.length) {
                return cnt1;
            }
            if (!isLimit && dp[i][cnt1] >= 0) {
                return dp[i][cnt1];
            }
            int ans = 0;
            int up = isLimit ? s[i] - '0' : 9;
            for (int d = 0; d <= up; d++) {
                ans += f(i + 1, cnt1 + (d == 1 ? 1 : 0), isLimit && d == up);
            }
            if (!isLimit) {
                dp[i][cnt1] = ans;
            }
            return ans;
        }
    }

    class Solution1 {
        public int countDigitOne(int n) {
            String s = String.valueOf(n);
            int m = s.length();
            if (m == 1) {
                return n > 0 ? 1 : 0;
            }
            int[] prefix_n = new int[m], suffix_n = new int[m];
            suffix_n[0] = Integer.parseInt(s.substring(1));
            for (int i = 1; i < m - 1; i++) {
                prefix_n[i] = Integer.parseInt(s.substring(0, i));
                suffix_n[i] = Integer.parseInt(s.substring(i + 1));
            }
            prefix_n[m - 1] = Integer.parseInt(s.substring(0, m - 1));
            int ans = 0;
            for (int i = 0; i < m; i++) {
                int x = s.charAt(i) - '0', len = m - i - 1;
                int prefix = prefix_n[i], suffix = suffix_n[i];
                int tot = 0;
                tot += (int) (prefix * Math.pow(10, len));
                if (x == 1) {
                    tot += (suffix + 1);
                } else if (x > 1) {
                    tot += (int) (Math.pow(10, len));
                }
                ans += tot;
            }
            return ans;
        }
    }
}