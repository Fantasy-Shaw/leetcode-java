package org.example.solutions.leetcode2k;

public class Solution2917 {
    class Solution {
        public int findKOr(int[] nums, int k) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                if (isOne(nums, i, k)) {
                    ans |= (1 << i);
                }
            }
            return ans;
        }

        private boolean isOne(int[] nums, int x, int k) {
            int cnt = 0;
            for (int i : nums) {
                if ((i >> x & 1) == 1) cnt++;
            }
            return cnt >= k;
        }
    }
}