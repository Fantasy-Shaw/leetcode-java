package org.example.solutions.leetcode501to1k;

public class Solution926 {
    class Solution {
        public int minFlipsMonoIncr(String s) {
            int n = s.length();
            if (n == 1) {
                return 0;
            }
            char[] cs = s.toCharArray();
            int[][] f = new int[n][2];
            f[0][0] = cs[0] == '0' ? 0 : 1;
            f[0][1] = cs[0] == '1' ? 0 : 1;
            for (int i = 1; i < n; i++) {
                f[i][0] = f[i - 1][0] + (cs[i] == '0' ? 0 : 1);
                f[i][1] = Math.min(f[i - 1][0], f[i - 1][1]) + (cs[i] == '1' ? 0 : 1);
            }
            return Math.min(f[n - 1][0], f[n - 1][1]);
        }
    }
}