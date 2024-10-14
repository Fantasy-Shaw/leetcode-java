package org.example.solutions.leetcode2k;

import java.util.Arrays;

public class Solution2576 {
    class Solution {
        public int maxNumOfMarkedIndices(int[] nums) {
            int n = nums.length;
            Arrays.sort(nums);
            int l = 0, r = n / 2 + 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (isValid(nums, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return (l - 1) * 2;
        }

        private static boolean isValid(int[] nums, int k) {
            for (int i = 0; i < k; i++) {
                if (nums[i] * 2 > nums[nums.length - k + i]) {
                    return false;
                }
            }
            return true;
        }
    }
}