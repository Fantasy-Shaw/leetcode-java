package org.example.solutions.leetcode1kto2k;

public class Solution1031 {
    class Solution {
        public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
            int n = nums.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
            return Math.max(solve(sum, firstLen, secondLen), solve(sum, secondLen, firstLen));
        }

        private int solve(int[] sum, int lLen, int rLen) {
            int mxLSum = 0, ans = 0;
            for (int i = lLen + rLen; i < sum.length; i++) {
                mxLSum = Math.max(mxLSum, sum[i - rLen] - sum[i - rLen - lLen]);
                ans = Math.max(ans, mxLSum + sum[i] - sum[i - rLen]);
            }
            return ans;
        }
    }
}