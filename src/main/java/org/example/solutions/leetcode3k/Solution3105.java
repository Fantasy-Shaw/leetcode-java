package org.example.solutions.leetcode3k;

public class Solution3105 {
    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int n = nums.length;
            int ans = 0;
            for (int i = 0; i < n; ) {
                int j = i + 1;
                while (j < n && nums[j] > nums[j - 1]) {
                    j++;
                }
                ans = Math.max(ans, j - i);
                i = j;
            }
            for (int i = 0; i < n; ) {
                int j = i + 1;
                while (j < n && nums[j] < nums[j - 1]) {
                    j++;
                }
                ans = Math.max(ans, j - i);
                i = j;
            }
            return ans;
        }
    }
}