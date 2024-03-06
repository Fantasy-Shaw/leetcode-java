package org.example.solutions.leetcode201to500;

public class Solution338 {
    class Solution {
        /**
         * 1(1) = 0(0) + 1
         * 7(111, 3) = 6(110, 2) + 1
         * 6(110, 2) = 2(010, 1) + 1
         */
        public int[] countBits(int n) {
            int[] ans = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                ans[i] = ans[i & (i - 1)] + 1;
            }
            return ans;
        }
    }
}