package org.example.solutions.leetcode1to200;

import org.example.templates.RolliingHash.StringHash;

public class Solution132 {
    class Solution1 {
        char[] cs;

        public int minCut(String s) {
            cs = s.toCharArray();
            int n = s.length();
            Boolean[][] isPalindrome = new Boolean[n][n];
            for (int i = 0; i < n; i++) {
                isPalindrome[i][i] = true;
                for (int j = i; j < n; j++) {
                    dfs(i, j, isPalindrome);
                }
            }
            int[] f = new int[n];
            // "abcdbd"
            for (int i = 1; i < n; i++) {
                f[i] = f[i - 1] + 1;
                for (int j = 0; j < i; j++) {
                    if (isPalindrome[j][i]) {
                        if (j == 0) { // A full palindrome shouldn't be split.
                            f[i] = 0;
                        } else {
                            f[i] = Math.min(f[i], f[j - 1] + 1);
                        }
                    }
                }
            }
            return f[n - 1];
        }

        private boolean dfs(int i, int j, Boolean[][] memo) {
            if (i >= j) {
                return true;
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            boolean ans = cs[i] == cs[j] && dfs(i + 1, j - 1, memo);
            memo[i][j] = ans;
            return ans;
        }
    }
    class PalindromeChecker {
        private final StringHash hash, revHash;
        private final int n;

        public PalindromeChecker(String s) {
            n = s.length();
            hash = new StringHash(s);
            revHash = new StringHash(new StringBuilder(s).reverse().toString());
        }

        public boolean isPalindrome(int i, int j) {
            return hash.getHash(i, j) == revHash.getHash(n - j, n - i);
        }
    }

    class Solution {
        private PalindromeChecker checker;

        // f(i)=min[j=0->i]{f(j-1)}+1, if s.substr(i,j) is palindrome
        public int minCut(String s) {
            int n = s.length();
            checker = new PalindromeChecker(s);
            int[] dp = new int[n];
            for (int i = 1; i < n; i++) {
                dp[i] = dp[i - 1] + 1;
                for (int j = i - 1; j >= 0; j--) {
                    if (checker.isPalindrome(j, i + 1)) {
                        dp[i] = (j == 0) ? 0 : Math.min(dp[i], dp[j - 1] + 1);
                    }
                }
            }
            return dp[n - 1];
        }

        private boolean isPalindrome(char[] arr, int l, int r) {
            while (l < r) {
                if (arr[l] != arr[r]) return false;
                l++;
                r--;
            }
            return true;
        }
    }
}