package org.example.solutions.leetcode3k;

public class Solution3011 {
    class Solution {
        public boolean canSortArray(int[] nums) {
            for (int j = 1; j < nums.length; j++) {
                for (int i = 1; i < nums.length; i++) {
                    if (nums[i - 1] > nums[i]) {
                        int t = nums[i - 1];
                        nums[i - 1] = nums[i];
                        nums[i] = t;
                        if (Integer.bitCount(nums[i - 1]) != Integer.bitCount(nums[i])) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }
    }
}