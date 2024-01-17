package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2719 {
    class Solution {
        private static final int mod = (int) 1e9 + 7;
        private String num1, num2;
        private int min_sum, max_sum;
        private int[][] memo;

        public int count(String num1, String num2, int min_sum, int max_sum) {
            int n = num2.length();
            this.num1 = "0".repeat(n - num1.length()) + num1;
            this.num2 = num2;
            this.min_sum = min_sum;
            this.max_sum = max_sum;
            memo = new int[n][Math.min(n * 9, max_sum) + 1];
            for (int[] r : memo) {
                Arrays.fill(r, -1);
            }
            return dfs(0, 0, true, true);
        }

        private int dfs(int i, int sum, boolean limLow, boolean limHigh) {
            if (sum > max_sum) {
                return 0;
            }
            if (i == num2.length()) {
                return sum >= min_sum ? 1 : 0;
            }
            if (!limLow && !limHigh && memo[i][sum] != -1) {
                return memo[i][sum];
            }
            int lo = limLow ? num1.charAt(i) - '0' : 0;
            int hi = limHigh ? num2.charAt(i) - '0' : 9;
            int res = 0;
            for (int d = lo; d <= hi; d++) {
                res += dfs(i + 1, sum + d, limLow && d == lo, limHigh && d == hi);
                res %= mod;
            }
            if (!limLow && !limHigh) {
                memo[i][sum] = res;
            }
            return res;
        }
    }
}