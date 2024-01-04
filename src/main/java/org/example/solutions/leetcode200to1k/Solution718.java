package org.example.solutions.leetcode200to1k;

public class Solution718 {
    class Solution {
        public int findLength(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length;
            int[][] dp = new int[m + 1][n + 1];
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i + 1][j + 1] = nums1[i] == nums2[j] ? dp[i][j] + 1 : 0;
                    ans = Math.max(ans, dp[i + 1][j + 1]);
                }
            }
            return ans;
        }
    }
}