package org.example.solutions.leetcode201to500;

public class Solution494 {
    class Solution {
        /**
         * 添加+的元素和为p
         * 添加-的元素和为sum-p
         * ans = p - (sum - p) = target
         * ==> p = (sum + target) / 2 ==> 0-1 Package
         */
        public int findTargetSumWays(int[] nums, int target) {
            int sum = target;
            for (int x : nums) {
                sum += x;
            }
            if (sum < 0 || sum % 2 == 1) return 0;
            sum /= 2;
            int n = nums.length;
            int[][] dp = new int[n + 1][sum + 1];
            dp[0][0] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= sum; j++) {
                    dp[i + 1][j] = dp[i][j] + (j < nums[i] ? 0 : dp[i][j - nums[i]]);
                }
            }
            return dp[n][sum];
        }
    }
}