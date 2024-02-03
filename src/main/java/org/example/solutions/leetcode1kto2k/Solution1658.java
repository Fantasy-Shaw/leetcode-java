package org.example.solutions.leetcode1kto2k;

public class Solution1658 {
    class Solution {
        public int minOperations(int[] nums, int x) {
            //Sum of the longest sub seq equals sum-x.
            int target = 0;
            for (int n : nums) {
                target += n;
            }
            target -= x;
            if (target < 0) {
                return -1;
            }
            int ans = -1, l = 0, sum = 0, n = nums.length;
            for (int r = 0; r < n; r++) {
                sum += nums[r];
                while (l < n && sum > target) {
                    sum -= nums[l];
                    l++;
                }
                if (sum == target) {
                    ans = Math.max(ans, r - l + 1);
                }
            }
            return ans < 0 ? -1 : n - ans;
        }
    }
}