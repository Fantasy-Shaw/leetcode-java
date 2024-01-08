package org.example.solutions.leetcode1to200;

import org.example.templates.StringHash;

public class Solution5 {
    class PalindromeChecker {
        private final StringHash hash, revHash;
        private final int n;

        public PalindromeChecker(String s) {
            n = s.length();
            hash = new StringHash(s);
            revHash = new StringHash(new StringBuilder(s).reverse().toString());
        }

        public boolean isPalindrome(int i, int j) {
            return hash.getSubStrHash(i, j) == revHash.getSubStrHash(n - j, n - i);
        }
    }

    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n == 0) return "";
            int l = -1, r = -1, curMxLen = -1;
            PalindromeChecker checker = new PalindromeChecker(s);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (j - i < curMxLen) continue;
                    if (checker.isPalindrome(i, j)) {
                        l = i;
                        r = j;
                        curMxLen = j - i;
                    }
                }
            }
            return curMxLen == -1 ? "" : s.substring(l, r);
        }
    }
}