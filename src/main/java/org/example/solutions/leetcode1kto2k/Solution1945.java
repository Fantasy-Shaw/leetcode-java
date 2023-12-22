package org.example.solutions.leetcode1kto2k;

public class Solution1945 {
    class Solution {
        public int getLucky(String s, int k) {
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append((int) (c - 'a' + 1));
            }
            String num = sb.toString();
            while (k > 0) {
                int cur = 0;
                for (char c : num.toCharArray()) {
                    cur += (c - '0');
                }
                num = String.valueOf(cur);
                k--;
            }
            return Integer.parseInt(num);
        }
    }
}