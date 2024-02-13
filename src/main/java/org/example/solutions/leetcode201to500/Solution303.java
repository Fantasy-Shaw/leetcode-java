package org.example.solutions.leetcode201to500;

public class Solution303 {
    private class NumArray {

        private int[] cache;

        public NumArray(int[] nums) {
            cache = new int[nums.length + 1];
            cache[0] = 0;
            cache[1] = nums[0];
            for (int i = 2; i <= nums.length; i++) {
                cache[i] = cache[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int left, int right) {
            return cache[right + 1] - cache[left];
        }
    }
}
