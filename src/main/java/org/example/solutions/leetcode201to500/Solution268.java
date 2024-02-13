package org.example.solutions.leetcode201to500;

public class Solution268 {
    class Solution {
        // xor
        public int missingNumber(int[] nums) {
            int ans = 0;
            for (int n : nums) {
                ans ^= n;
            }
            for (int i = 0; i <= nums.length; i++) {
                ans ^= i;
            }
            return ans;
        }
    }
}