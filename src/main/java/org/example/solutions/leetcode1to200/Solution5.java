package org.example.solutions.leetcode1to200;

import org.example.templates.StringHash;

import java.util.Objects;

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
            int l = -1, r = -1, curMxLen = 0;
            PalindromeChecker checker = new PalindromeChecker(s);
            for (int i = 0; i < n; i++) {
                for (int j = i + 1 + curMxLen; j <= n; j++) {
                    if (checker.isPalindrome(i, j)) {
                        l = i;
                        r = j;
                        curMxLen = j - i;
                    }
                }
            }
            return curMxLen == 0 ? "" : s.substring(l, r);
        }
    }

    class Solution1 {
        char[] cs;

        public String longestPalindrome(String s) {
            cs = s.toCharArray();
            int n = s.length();
            Boolean[][] memo = new Boolean[n][n];
            int l = 0, r = 0, curMx = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + curMx; j < n; j++) {
                    if (dfs(i, j, memo)) {
                        curMx = j - i + 1;
                        l = i;
                        r = j;
                    }
                }
            }
            return s.substring(l, r + 1);
        }

        private boolean dfs(int i, int j, Boolean[][] memo) {
            if (i > j) {
                return true;
            }
            if (i == j) {
                return true;
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            if (i + 1 == j) {
                boolean ans = cs[i] == cs[j];
                memo[i][j] = ans;
                return ans;
            }
            boolean ans = cs[i] == cs[j] && dfs(i + 1, j - 1, memo);
            memo[i][j] = ans;
            return ans;
        }
    }
}