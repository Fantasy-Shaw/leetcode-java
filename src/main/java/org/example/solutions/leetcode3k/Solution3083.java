package org.example.solutions.leetcode3k;

public class Solution3083 {
    class Solution {
        public boolean isSubstringPresent(String s) {
            int n = s.length();
            String rev = new StringBuilder(s).reverse().toString();
            for (int i = 0; i + 2 <= n; i++) {
                if (rev.contains(s.substring(i, i + 2))) {
                    return true;
                }
            }
            return false;
        }
    }
}