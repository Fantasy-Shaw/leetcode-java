package org.example.solutions.leetcode1to200;

public class Solution190 {
    public class Solution {
        // you need treat n as an unsigned value
        public int reverseBits(int n) {
            int ans = 0;
            for (int i = 0; i < 32; i++) {
                ans <<= 1;
                ans |= (n >> i & 1);
            }
            return ans;
        }
    }
}