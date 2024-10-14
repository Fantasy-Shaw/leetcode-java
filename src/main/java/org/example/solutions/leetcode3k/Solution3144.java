package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3144 {
    class Solution {
        public int minimumSubstringsInPartition(String _s) {
            char[] s = _s.toCharArray();
            int[] memo = new int[s.length];
            Arrays.fill(memo, -1);
            return dfs(s, 0, memo);

        }

        private int dfs(char[] s, int i, int[] memo) {
            if (i >= s.length) {
                return 0;
            }
            if (memo[i] != -1) {
                return memo[i];
            }
            int[] cnt = new int[26];
            int ans = s.length - i;
            for (int j = i; j < s.length; j++) {
                cnt[s[j] - 'a']++;
                if (isValid(cnt)) {
                    ans = Math.min(ans, 1 + dfs(s, j + 1, memo));
                }
            }
            return memo[i] = ans;
        }

        private static boolean isValid(int[] cnt) {
            int x = 0;
            for (int y : cnt) {
                if (y == 0) {
                    continue;
                }
                if (x == 0) {
                    x = y;
                }
                if (x != 0 && x != y) {
                    return false;
                }
            }
            return true;
        }
    }
}