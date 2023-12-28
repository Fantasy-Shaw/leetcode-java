package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2735 {
    class Solution {
        public long minCost(int[] nums, int x) {
            int n = nums.length;
            long[] s = new long[n];
            for (int i = 0; i < n; i++) {
                s[i] = (long) i * x;
            }
            for (int i = 0; i < n; i++) {
                int cur = nums[i];
                for (int j = i; j < i + n; j++) {
                    cur = Math.min(cur, nums[j % n]);
                    s[j - i] += cur;
                }
            }
            long ans = Long.MAX_VALUE;
            for (long a : s) {
                ans = Math.min(ans, a);
            }
            return ans;
        }
    }
}