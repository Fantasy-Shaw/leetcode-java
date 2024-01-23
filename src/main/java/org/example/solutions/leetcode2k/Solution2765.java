package org.example.solutions.leetcode2k;

public class Solution2765 {
    class Solution {
        public int alternatingSubarray(int[] nums) {
            int ans = 0, cur = 1;
            int i = 0, j = 0;
            while (i < nums.length) {
                while (j + 1 < nums.length && nums[j + 1] - nums[j] == cur) {
                    j++;
                    cur *= -1;
                }
                ans = Math.max((j == i) ? 0 : j - i + 1, ans);
                i = (i == j) ? (j + 1) : j;
                j = i;
                cur = 1;
            }
            return ans == 0 ? -1 : ans;
        }
    }
}