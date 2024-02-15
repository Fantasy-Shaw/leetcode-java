package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1862 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int sumOfFlooredPairs(int[] nums) {
            long ans = 0;
            int mx = 0;
            for (int i : nums) {
                mx = Math.max(mx, i);
            }
            long[] sum = new long[mx + 1];
            for (int i : nums) {
                sum[i]++;
            }
            for (int i = 0; i < mx; i++) {
                sum[i + 1] += sum[i];
            }
            for (int i = 1; i <= mx; i++) {
                long x = sum[i] - sum[i - 1];
                if (x == 0) {
                    continue;
                }
                for (int j = i; j <= mx; j += i) {
                    long y = sum[Math.min(mx, j + i - 1)] - sum[j - 1];
                    ans = (ans + (j / i) * y * x) % mod;
                }
            }
            return (int) ans;
        }
    }
}