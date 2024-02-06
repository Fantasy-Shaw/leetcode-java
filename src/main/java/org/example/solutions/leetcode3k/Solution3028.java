package org.example.solutions.leetcode3k;

public class Solution3028 {
    class Solution {
        public int returnToBoundaryCount(int[] nums) {
            int n = nums.length, ans = 0;
            int cur = nums[0];
            for (int i = 1; i < n; i++) {
                cur += nums[i];
                if (cur == 0) {
                    ans++;
                }
            }
            return ans;
        }
    }
}