package org.example.solutions.leetcode501to1k;

public class Solution724 {
    class Solution {
        public int pivotIndex(int[] nums) {
            long lSum = 0, rSum = 0;
            for (int i : nums) {
                rSum += i;
            }
            for (int i = 0; i < nums.length; i++) {
                rSum -= nums[i];
                if (lSum == rSum) {
                    return i;
                }
                lSum += nums[i];
            }
            return -1;
        }
    }
}