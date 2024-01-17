package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution405 {
    class Solution {
        private static final char[] table = "0123456789abcdef".toCharArray();

        public String toHex(int num) {
            long n = num >= 0 ? num : (1L << 32) + num;
            StringBuilder ans = new StringBuilder();
            while (n > 0) {
                ans.append(table[(int) (n % 16)]);
                n /= 16;
            }
            return ans.isEmpty() ? "0" : ans.reverse().toString();
        }
    }
}