package org.example.solutions.leetcode2k;

import org.example.templates.BinarySearch;

import java.util.Arrays;

public class Solution2779 {
    class Solution {
        public int maximumBeauty(int[] nums, int k) {
            int ans = 0;
            Arrays.sort(nums);
            for (int x : nums) {
                ans = Math.max(ans, BinarySearch.upperBound(nums, x + k) - BinarySearch.lowerBound(nums, x - k));
                ans = Math.max(ans, BinarySearch.upperBound(nums, x + k * 2) - BinarySearch.lowerBound(nums, x));
                ans = Math.max(ans, BinarySearch.upperBound(nums, x) - BinarySearch.lowerBound(nums, x - k * 2));
            }
            return ans;
        }
    }
}