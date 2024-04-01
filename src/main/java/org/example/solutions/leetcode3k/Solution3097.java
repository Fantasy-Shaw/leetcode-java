package org.example.solutions.leetcode3k;

public class Solution3097 {
    class Solution {
        public int minimumSubarrayLength(int[] nums, int k) {
            if (k == 0) {
                return 1;
            }
            int[] cnt = new int[32];
            int ans = Integer.MAX_VALUE;
            int n = nums.length, j = 0;
            for (int i = 0; i < n; ) {
                while (i < n && orSum(cnt) < k) {
                    add(cnt, nums[i]);
                    i++;
                }
                while (j < i && orSum(cnt) >= k) {
                    ans = Math.min(ans, i - j);
                    dec(cnt, nums[j]);
                    j++;
                }
            }
            return ans < Integer.MAX_VALUE ? ans : -1;
        }

        private int orSum(int[] cnt) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                int cur = cnt[i] > 0 ? 1 : 0;
                ans |= (cur << i);
            }
            return ans;
        }

        private void add(int[] cnt, int x) {
            for (int i = 0; i < 32; i++) {
                cnt[i] += (x >> i) & 1;
            }
        }

        private void dec(int[] cnt, int x) {
            for (int i = 0; i < 32; i++) {
                cnt[i] -= (x >> i) & 1;
            }
        }
    }
}