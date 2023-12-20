package org.example.solutions;

import java.util.*;

public class Solution132 {
    class RollingHash {
        private long[] pwr, hsh;
        private final long A = 31, M = (long) 1e9 + 7;
        int n;

        RollingHash(String str) {
            n = str.length();
            char[] s = str.toCharArray();
            pwr = new long[n + 1];
            hsh = new long[n + 1];

            pwr[0] = 1;
            for (int i = 1; i <= n; i++) pwr[i] = pwr[i - 1] * A % M;

            hsh[0] = s[0] % M + 1;
            for (int i = 1; i < n; i++) {
                hsh[i] = (hsh[i - 1] * A % M) + s[i] + 1;
                if (hsh[i] >= M) hsh[i] -= M;
            }
        }

        long getHash(int x, int y) {
            return (hsh[y] + M - ((x - 1 >= 0) ? hsh[x - 1] * pwr[y - x + 1] % M : 0)) % M;
        }
    }

    class PalindromeChecker {
        private final RollingHash hash, revHash;
        private final int n;

        PalindromeChecker(String str) {
            n = str.length();
            hash = new RollingHash(str);
            revHash = new RollingHash(new StringBuilder(str).reverse().toString());
        }

        public boolean isPalindrome(int i, int j) {
            return hash.getHash(i, j) == revHash.getHash(n - j - 1, n - i - 1);
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
                    if (checker.isPalindrome(j, i)) {
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