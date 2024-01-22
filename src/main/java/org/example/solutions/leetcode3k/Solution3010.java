package org.example.solutions.leetcode3k;

public class Solution3010 {
    class Solution {
        public int minimumCost(int[] nums) {
            int ans = Integer.MAX_VALUE;
            int n = nums.length;
            for (int i = 0; i < 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    for (int k = j + 1; k < n; k++) {
                        ans = Math.min(ans, nums[i] + nums[j] + nums[k]);
                    }
                }
            }
            return ans;
        }
    }
}