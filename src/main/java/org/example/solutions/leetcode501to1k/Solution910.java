package org.example.solutions.leetcode501to1k;

import java.util.Arrays;

public class Solution910 {
    static
    class Solution {
        public int smallestRangeII(int[] nums, int k) {
            Arrays.sort(nums);
            final int n = nums.length;
            int ans = nums[n - 1] - nums[0];
            for (int i = 1; i < n; i++) {
                int mx = Math.max(nums[i - 1] + k, nums[n - 1] - k);
                int mn = Math.min(nums[i] - k, nums[0] + k);
                ans = Math.min(ans, mx - mn);
            }
            return ans;
        }
    }
}