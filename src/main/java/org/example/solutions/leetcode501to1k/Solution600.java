package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution600 {
    class Solution { // 数位DP
        char[] cs;
        int[][] dp;

        public int findIntegers(int n) {
            cs = Integer.toBinaryString(n).toCharArray();
            int m = cs.length;
            dp = new int[m][2];
            for (var it : dp) {
                Arrays.fill(it, -1);
            }
            return dfs(0, false, true);
        }

        private int dfs(int i, boolean preIsOne, boolean isLimit) {
            if (i == cs.length) {
                return 1;
            }
            if (!isLimit && dp[i][preIsOne ? 1 : 0] >= 0) {
                return dp[i][preIsOne ? 1 : 0];
            }
            int up = isLimit ? cs[i] - '0' : 1;
            int ans = 0;
            // 下一位一定可以填0
            ans += dfs(i + 1, false, isLimit && up == 0);
            // 这一位不是1下一位才能填1
            if (!preIsOne && up == 1) {
                ans += dfs(i + 1, true, isLimit);
            }
            if (!isLimit) {
                dp[i][preIsOne ? 1 : 0] = ans;
            }
            return ans;
        }
    }
}