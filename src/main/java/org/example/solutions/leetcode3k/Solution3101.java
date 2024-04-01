package org.example.solutions.leetcode3k;

public class Solution3101 {
    class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            int n = nums.length;
            long ans = 0;
            for (int i = 0; i < n; ) {
                int j = i + 1;
                while (j < n && nums[j] != nums[j - 1]) {
                    j++;
                }
                int cnt = j - i;
                ans += cnt;
                ans += (long) cnt * (cnt - 1) / 2;
                i = j;
            }
            return ans;
        }
    }
}