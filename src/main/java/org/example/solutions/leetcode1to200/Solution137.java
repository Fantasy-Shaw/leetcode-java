package org.example.solutions.leetcode1to200;

public class Solution137 {
    class Solution {
        public int singleNumber(int[] nums) {
            int[] cnt = new int[32];
            for (int x : nums) {
                for (int i = 0; i < 32; i++) {
                    cnt[i] += (x >> i) & 1;
                }
            }
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                ans |= (cnt[i] % 3) << i;
            }
            return ans;
        }
    }
}