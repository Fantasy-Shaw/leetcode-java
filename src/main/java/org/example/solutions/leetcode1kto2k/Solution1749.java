package org.example.solutions.leetcode1kto2k;

public class Solution1749 {
    class Solution {
        public int maxAbsoluteSum(int[] nums) {
            int n = nums.length;
            int[] prefix = new int[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            int mn = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
            for (int i = 0; i <= n; i++) {
                mn = Math.min(mn, prefix[i]);
                mx = Math.max(mx, prefix[i]);
            }
            return mx - mn;
        }
    }
}