package org.example.solutions.leetcode2k;

public class Solution2789 {
    class Solution {
        public long maxArrayValue(int[] nums) {
            int n = nums.length;
            if (n == 1) {
                return nums[0];
            }
            long ans = nums[n - 1];
            for (int i = n - 1; i >= 0; ) {
                long cur = nums[i];
                int j = i - 1;
                while (j >= 0 && nums[j] <= cur) {
                    cur += nums[j];
                    j--;
                }
                i = j;
                ans = Math.max(ans, cur);
            }
            return ans;
        }
    }
}