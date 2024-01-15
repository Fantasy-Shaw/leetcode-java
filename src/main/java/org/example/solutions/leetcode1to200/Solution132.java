package org.example.solutions.leetcode1to200;

import org.example.templates.StringHash;

import java.util.*;

public class Solution132 {
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