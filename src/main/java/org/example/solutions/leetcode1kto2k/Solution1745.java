package org.example.solutions.leetcode1kto2k;

import org.example.templates.DoubleStringHash;

import java.util.Arrays;

public class Solution1745 {
    class Solution {
        private DoubleStringHash hash, revHash;

        public boolean checkPartitioning(String s) {
            hash = new DoubleStringHash(s);
            revHash = new DoubleStringHash(new StringBuilder(s).reverse());
            Boolean[][] memo = new Boolean[s.length()][3];
            return dfs(s, 0, 2, memo);
        }

        public boolean dfs(String s, int l, int x, Boolean[][] memo) {
            if (memo[l][x] != null) return memo[l][x];
            if (x == 0) {
                return memo[l][x] = isPalindrome(s, l, s.length() - 1);
            }
            boolean ans = false;
            for (int i = l; i < s.length() - 1; i++) {
                if (isPalindrome(s, l, i)) {
                    ans |= dfs(s, i + 1, x - 1, memo);
                }
            }
            return memo[l][x] = ans;
        }

        private boolean isPalindrome(String s, int l, int r) {
            return Arrays.equals(hash.getHash(l, r + 1), revHash.getHash(s.length() - r - 1, s.length() - l));
        }
    }
}