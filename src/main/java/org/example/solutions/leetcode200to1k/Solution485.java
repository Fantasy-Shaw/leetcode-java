package org.example.solutions.leetcode200to1k;

public class Solution485 {
    class Solution {
        public int findMaxConsecutiveOnes(int[] nums) {
            int ans = 0, n = nums.length;
            int i = 0, j = 0;
            while (i < n) {
                if (nums[i] != 1) {
                    i++;
                } else {
                    j = i;
                    while (j < n && nums[j] == 1) j++;
                    ans = Math.max(ans, j - i);
                    i = j;
                }
            }
            return ans;
        }
    }
}