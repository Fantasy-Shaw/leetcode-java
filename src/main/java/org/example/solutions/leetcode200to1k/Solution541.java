package org.example.solutions.leetcode200to1k;

public class Solution541 {
    class Solution {
        public String reverseStr(String s, int k) {
            if (s.length() <= k) {
                return new StringBuilder(s).reverse().toString();
            }
            StringBuilder ans = new StringBuilder();
            int t = 0;
            for (int i = 0; i <= s.length(); i += k) {
                int l = i, r = Math.min(s.length(), i + k);
                if (t % 2 == 0) {
                    ans.append(new StringBuilder(s.substring(l, r)).reverse());
                } else {
                    ans.append(s, l, r);
                }
                t++;
            }
            return ans.toString();
        }
    }
}