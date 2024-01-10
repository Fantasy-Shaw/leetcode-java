package org.example.solutions.leetcode2k;

public class Solution2696 {
    class Solution {
        public int minLength(String s) {
            int preLen = s.length();
            while (true) {
                s = s.replaceAll("AB", "").replaceAll("CD", "");
                if (s.length() == preLen) {
                    break;
                } else {
                    preLen = s.length();
                }
            }
            return s.length();
        }
    }
}