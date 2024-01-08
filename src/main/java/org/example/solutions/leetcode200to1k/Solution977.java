package org.example.solutions.leetcode200to1k;

public class Solution977 {
    class Solution {
        public int[] sortedSquares(int[] nums) {
            int[] ans = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = nums[i] * nums[i];
            }
            int l = 0, i = nums.length - 1, r = nums.length - 1;
            while (l <= r) {
                if (nums[l] > nums[r]) {
                    ans[i] = nums[l];
                    l++;
                } else {
                    ans[i] = nums[r];
                    r--;
                }
                i--;
            }
            return ans;
        }
    }
}