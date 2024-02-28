package org.example.solutions.leetcode1to200;

public class Solution53 {
    class Solution {
        public int maxSubArray(int[] nums) {
            int sum = 0;
            int ans = Integer.MIN_VALUE;
            for (int i : nums) {
                sum = Math.max(sum + i, i);
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }
}