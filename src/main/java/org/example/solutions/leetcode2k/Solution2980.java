package org.example.solutions.leetcode2k;

public class Solution2980 {
    class Solution {
        public boolean hasTrailingZeros(int[] nums) {
            int n = 0;
            for (int i : nums) {
                if (i % 2 == 0) n++;
            }
            return n > 1;
        }
    }
}