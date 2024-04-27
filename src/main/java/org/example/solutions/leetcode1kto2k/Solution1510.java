package org.example.solutions.leetcode1kto2k;


public class Solution1510 {
    class Solution {
        public boolean winnerSquareGame(int n) {
            Boolean[] f = new Boolean[n + 1];
            return dfs(n, 1, f);
        }

        private boolean dfs(int n, int curAlice, Boolean[] f) {
            if (n == 0) {
                return false;
            }
            if (f[n] != null) return f[n];
            for (int i = 1; i * i <= n; i++) {
                if (!dfs(n - i * i, (~curAlice) & 1, f)) {
                    return f[n] = true;
                }
            }
            return f[n] = false;
        }
    }
}