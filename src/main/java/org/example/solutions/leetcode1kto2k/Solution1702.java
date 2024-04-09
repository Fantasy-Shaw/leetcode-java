package org.example.solutions.leetcode1kto2k;

public class Solution1702 {
    class Solution {
        public String maximumBinaryString(String binary) {
            int n = binary.length();
            if (n <= 1) {
                return binary;
            }
            char[] s = binary.toCharArray();
            int i = 0;
            for (; i < n - 1; i++) {
                if (s[i] == '0' && s[i + 1] == '0') {
                    s[i] = '1';
                } else if (s[i] == '1') {
                    continue;
                } else {
                    break;
                }
            }
            int zeros = 0, ones = 0;
            for (int j = i; j < n; j++) {
                if (s[j] == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int k = 0; k < ones; k++) {
                s[n - k - 1] = '1';
            }
            if (zeros > 0) {
                for (int k = 0; k < zeros - 1; k++) {
                    s[i + k] = '1';
                }
                s[i + zeros - 1] = '0';
            }
            return new String(s);
        }
    }
}