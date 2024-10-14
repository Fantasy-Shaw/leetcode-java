package org.example.solutions.leetcode201to500;

import java.util.Arrays;

public class Solution312 {
    class Solution {
        public int maxCoins(int[] nums) {
            int[] nums2 = new int[nums.length + 2];
            nums2[0] = nums2[nums2.length - 1] = 1;
            System.arraycopy(nums, 0, nums2, 1, nums.length);
            nums = nums2;
            int[][] memo = new int[nums.length][nums.length];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            for (int len = 2; len < nums.length; len++) {
                for (int i = 0; i < nums.length - len; i++) {
                    dfs(nums, i, i + len, memo);
                }
            }
            return dfs(nums, 0, nums.length - 1, memo);
        }

        private int dfs(int[] nums, int i, int j, int[][] memo) {
            if (i >= j) {
                return 0;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            int ans = 0;
            for (int k = i + 1; k < j; k++) {
                int cur = dfs(nums, i, k, memo) + dfs(nums, k, j, memo) + nums[i] * nums[j] * nums[k];
                ans = Math.max(ans, cur);
            }
            return memo[i][j] = ans;
        }
    }
}