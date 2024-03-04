package org.example.solutions.leetcode1to200;

public class Solution153 {
    class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            if (n == 1 || nums[0] < nums[n - 1]) {
                return nums[0];
            }
            // compare with right-end
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = (l + r) / 2;
                if (nums[mid] >= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return nums[l];
        }
    }
}