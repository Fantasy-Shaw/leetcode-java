package org.example.solutions.leetcode1to200;

public class Solution42 {
    class Solution {
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int n = height.length;
            int[] leftMx = new int[n], rightMx = new int[n];
            leftMx[0] = height[0];
            for (int i = 1; i < n; i++) {
                leftMx[i] = Math.max(height[i], leftMx[i - 1]);
            }
            rightMx[n - 1] = height[n - 1];
            for (int i = n - 2; i >= 0; i--) {
                rightMx[i] = Math.max(height[i], rightMx[i + 1]);
            }
            int ans = 0;
            for (int i = 1; i < n - 1; i++) {
                ans += Math.min(leftMx[i], rightMx[i]) - height[i];
            }
            return ans;
        }
    }
}
