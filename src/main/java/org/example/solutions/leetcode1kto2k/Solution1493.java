package org.example.solutions.leetcode1kto2k;

public class Solution1493 {
    class Solution {
        public int longestSubarray(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return 0;
            }
            int[] pre = new int[n], suf = new int[n];
            pre[0] = nums[0] == 1 ? 1 : 0;
            for (int i = 1; i < n; i++) {
                pre[i] = nums[i] == 1 ? pre[i - 1] + 1 : 0;
            }
            suf[n - 1] = nums[n - 1] == 1 ? 1 : 0;
            for (int i = n - 2; i >= 0; i--) {
                suf[i] = nums[i] == 1 ? suf[i + 1] + 1 : 0;
            }
            int ans = 0;
            // if del nums[i]
            for (int i = 1; i <= n - 2; i++) {
                ans = Math.max(ans, pre[i - 1] + suf[i + 1]);
            }
            // corner case
            ans = Math.max(ans, suf[1]);
            ans = Math.max(ans, pre[n - 2]);
            return ans;
        }
    }
}