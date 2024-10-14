package org.example.solutions.leetcode1kto2k;

import java.util.Arrays;

public class Solution1798 {
    class Solution {
        /**
         * Leetcode-330,2952
         */
        public int getMaximumConsecutive(int[] coins) {
            Arrays.sort(coins);
            int m = 0;
            for (int c : coins) {
                if (c > m + 1) {
                    break;
                }
                m += c;
            }
            return m + 1; // [0,m] contains m+1 nums.
        }
    }
}