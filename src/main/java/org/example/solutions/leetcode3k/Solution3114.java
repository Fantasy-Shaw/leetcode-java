package org.example.solutions.leetcode3k;

public class Solution3114 {
    class Solution {
        public String findLatestTime(String s) {
            char[] cs = s.toCharArray();
            if (cs[0] == '?') {
                cs[0] = (cs[1] != '?' && cs[1] > '1') ? '0' : '1';
            }
            if (cs[1] == '?') {
                cs[1] = cs[0] == '1' ? '1' : '9';
            }
            if (cs[3] == '?') {
                cs[3] = '5';
            }
            if (cs[4] == '?') {
                cs[4] = '9';
            }
            return new String(cs);
        }
    }
}