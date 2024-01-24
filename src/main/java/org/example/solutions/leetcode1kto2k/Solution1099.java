package org.example.solutions.leetcode1kto2k;

import org.example.templates.BinarySearch;

import java.util.Arrays;

public class Solution1099 {
    class Solution {
        public int twoSumLessThanK(int[] nums, int k) {
            Arrays.sort(nums);
            int n = nums.length;
            int ans = -1;
            for (int i = 0; i < n; i++) {
                int x = BinarySearch.lowerBound(nums, k - nums[i]);
                int j = Math.max(0, x - 1);
                int cur = nums[i] + nums[j];
                if (i != j && cur < k) {
                    ans = Math.max(ans, cur);
                }
            }
            return ans;
        }
    }
}