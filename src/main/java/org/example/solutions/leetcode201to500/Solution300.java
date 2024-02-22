package org.example.solutions.leetcode201to500;

import java.util.Arrays;

public class Solution300 {
    class Solution {
        public int lengthOfLIS(int[] nums) {
            int n = nums.length;
            // LIS ends with i
            int[] dp = new int[n];
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return Arrays.stream(dp).max().getAsInt();
        }
    }
}