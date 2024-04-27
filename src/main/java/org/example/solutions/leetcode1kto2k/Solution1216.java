package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1216 {
    class Solution {
        Map<Integer, Boolean> memo;

        public boolean isValidPalindrome(String s, int k) {
            memo = new HashMap<>();
            return dfs(s, 0, s.length() - 1, k);
        }

        private boolean dfs(String s, int l, int r, int k) {
            if (l >= r) {
                return true;
            }
            int key = (l << 20) | (r << 10) | k;
            if (memo.containsKey(key)) {
                return memo.get(key);
            }
            boolean ans;
            if (s.charAt(l) == s.charAt(r)) {
                ans = dfs(s, l + 1, r - 1, k);
            } else {
                if (k == 0) {
                    ans = false;
                } else {
                    ans = dfs(s, l + 1, r, k - 1) || dfs(s, l, r - 1, k - 1);
                }
            }
            memo.put(key, ans);
            return ans;
        }
    }
}