package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2999 {
    class Solution {
        private long[] memo;
        private String low, high, s;
        private int limit;

        public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
            low = Long.toString(start);
            high = Long.toString(finish);
            int n = high.length();
            low = "0".repeat(n - low.length()) + low;   // Add leading zeros
            memo = new long[n];
            Arrays.fill(memo, -1);
            this.limit = limit;
            this.s = s;
            return dfs(0, true, true);
        }

        private long dfs(int i, boolean limLow, boolean limHigh) { // 数位DP
            if (i == high.length()) {
                return 1;
            }
            if (!limHigh && !limLow && memo[i] != -1) {
                return memo[i];
            }
            int lo = limLow ? low.charAt(i) - '0' : 0;
            int hi = limHigh ? high.charAt(i) - '0' : 9;
            long res = 0;
            if (i < high.length() - s.length()) {
                for (int digit = lo; digit <= Math.min(hi, limit); digit++) {
                    res += dfs(i + 1, limLow && digit == lo, limHigh && digit == hi);
                }
            } else {    // i == high.length() - s.length(), cur digit is s[i-diff]
                int x = s.charAt(i - (high.length() - s.length())) - '0';
                if (lo <= x && x <= Math.min(hi, limit)) {
                    res = dfs(i + 1, limLow && x == lo, limHigh && x == hi);
                }

            }
            if (!limLow && !limHigh) {
                memo[i] = res;
            }
            return res;
        }
    }
}