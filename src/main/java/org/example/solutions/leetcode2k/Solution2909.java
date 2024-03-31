package org.example.solutions.leetcode2k;

public class Solution2909 {
    class Solution {
        public int minimumSum(int[] nums) {
            int n = nums.length;
            int[] leftMn = new int[n], rightMn = new int[n];
            leftMn[0] = Integer.MAX_VALUE / 2;
            for (int i = 1; i < n; i++) {
                leftMn[i] = Math.min(leftMn[i - 1], nums[i - 1]);
            }
            rightMn[n - 1] = Integer.MAX_VALUE / 2;
            for (int i = n - 2; i >= 0; i--) {
                rightMn[i] = Math.min(rightMn[i + 1], nums[i + 1]);
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (nums[i] > leftMn[i] && nums[i] > rightMn[i]) {
                    ans = Math.min(ans, leftMn[i] + nums[i] + rightMn[i]);
                }
            }
            return ans < Integer.MAX_VALUE / 2 ? ans : -1;
        }
    }
}