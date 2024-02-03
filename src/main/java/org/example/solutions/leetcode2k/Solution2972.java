package org.example.solutions.leetcode2k;

public class Solution2972 {
    class Solution {
        public long incremovableSubarrayCount(int[] nums) {
            int n = nums.length;
            int i = 0;
            while (i < n - 1 && nums[i] < nums[i + 1]) {
                i++;
            }
            if (i == n - 1) {
                return (long) n * (n + 1) / 2;
            }
            long ans = i + 2;
            for (int j = n - 1; j == n - 1 || nums[j] < nums[j + 1]; j--) {
                while (i >= 0 && nums[i] >= nums[j]) {
                    i--;
                }
                ans += (i + 2);
            }
            return ans;
        }
    }
}