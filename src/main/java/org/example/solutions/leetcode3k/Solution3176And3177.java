package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3176And3177 {
    class Solution {
        public int maximumLength(int[] nums, int k) {
            Map<Integer, int[]> map = new HashMap<>();
            int[][] dp = new int[k + 1][3];
            for (int x : nums) {
                int[] f = map.computeIfAbsent(x, any -> new int[k + 1]);
                for (int i = k; i >= 0; i--) {
                    f[i]++;
                    if (i > 0) {
                        int mx = dp[i - 1][0], mx2 = dp[i - 1][1], num = dp[i - 1][2];
                        f[i] = Math.max(f[i], 1 + (x == num ? mx2 : mx));
                    }
                    if (f[i] > dp[i][0]) {
                        if (x != dp[i][2]) {
                            dp[i][2] = x;
                            dp[i][1] = dp[i][0];
                        }
                        dp[i][0] = f[i];
                    } else if (f[i] > dp[i][1]) {
                        if (x != dp[i][2]) {
                            dp[i][1] = f[i];
                        }
                    }
                }
            }
            return dp[k][0];
        }
    }
}