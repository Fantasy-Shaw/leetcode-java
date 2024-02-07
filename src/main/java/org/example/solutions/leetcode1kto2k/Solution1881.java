package org.example.solutions.leetcode1kto2k;

public class Solution1881 {
    class Solution {
        public String maxValue(String n, int x) {
            if (n.charAt(0) == '-') {
                for (int i = 1; i < n.length(); i++) {
                    int cur = n.charAt(i) - '0';
                    if (cur > x) return n.substring(0, i) + x + n.substring(i);
                }
            } else {
                for (int i = 0; i < n.length(); i++) {
                    int cur = n.charAt(i) - '0';
                    if (cur < x) return n.substring(0, i) + x + n.substring(i);
                }
            }
            return n + x;
        }
    }
}