package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3107 {
    class Solution {
        public long minOperationsToMakeMedianK(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int mid = n / 2;
            long ans = 0;
            ans += (Math.abs(nums[mid] - k));
            nums[mid] = k;
            for (int i = mid - 1; i >= 0; i--) {
                if (nums[i] > nums[i + 1]) {
                    ans += (nums[i] - nums[i + 1]);
                    nums[i] = nums[i + 1];
                }
            }
            for (int i = mid + 1; i < n; i++) {
                if (nums[i] < nums[i - 1]) {
                    ans += (nums[i - 1] - nums[i]);
                    nums[i] = nums[i - 1];
                }
            }
            return ans;
        }
    }
}