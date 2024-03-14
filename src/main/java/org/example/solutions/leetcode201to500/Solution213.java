package org.example.solutions.leetcode201to500;

public class Solution213 {
    class Solution {
        /**
         * if nums[0] selected, no selecting nums[1] and nums[n-1], nums[2:n-1] as a row
         * if nums[0] not selected, nums[1,n] as a row
         */
        public int rob(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            } else if (n == 2) {
                return Math.max(nums[0], nums[1]);
            }
            // select nums[0]
            int ans1 = nums[0];
            if (n > 3) {
                int[] f = new int[n];
                f[2] = nums[2];
                f[3] = Math.max(nums[2], nums[3]);
                for (int i = 4; i <= n - 2; i++) {
                    f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
                }
                ans1 += f[n - 2];
            }
            // don't select nums[0]
            int[] f = new int[n];
            f[1] = nums[1];
            f[2] = Math.max(nums[1], nums[2]);
            for (int i = 3; i < n; i++) {
                f[i] = Math.max(f[i - 1], f[i - 2] + nums[i]);
            }
            return Math.max(ans1, f[n - 1]);
        }
    }
}