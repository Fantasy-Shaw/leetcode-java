package org.example.solutions.leetcode1to200;

public class Solution97 {
    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            if (s1.length() + s2.length() != s3.length()) {
                return false;
            }
            if (s1.isEmpty()) return s2.equals(s3);
            if (s2.isEmpty()) return s1.equals(s3);
            return dfs(
                    s1.toCharArray(),
                    s2.toCharArray(),
                    s3.toCharArray(),
                    0, 0, new Boolean[s1.length() + 1][s2.length() + 1]
            );
        }

        private boolean dfs(char[] s1, char[] s2, char[] s3, int i, int j, Boolean[][] memo) {
            if (i == s1.length && j == s2.length) {
                return true;
            }
            if (memo[i][j] != null) {
                return memo[i][j];
            }
            boolean ans = false;
            if (i < s1.length) {
                ans |= s1[i] == s3[i + j] && dfs(s1, s2, s3, i + 1, j, memo);
            }
            if (j < s2.length) {
                ans |= s2[j] == s3[i + j] && dfs(s1, s2, s3, i, j + 1, memo);
            }
            memo[i][j] = ans;
            return ans;
        }
    }
}