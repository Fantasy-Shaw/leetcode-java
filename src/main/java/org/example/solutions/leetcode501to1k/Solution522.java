package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution522 {
    class Solution {
        public int findLUSlength(String[] strs) {
            int ans = -1;
            int n = strs.length;
            for (int i = 0; i < n; i++) {
                int j = 0;
                for (; j < n; j++) {
                    if (i == j) continue;
                    if (strs[i].length() > strs[j].length()) continue;
                    if (lcs(strs[i], strs[j]) == strs[i].length()) {
                        break;
                    }
                }
                if (j == n) {
                    ans = Math.max(ans, strs[i].length());
                }
            }
            return ans;
        }

        //Leetcode-1143 LCS
        private int lcs(String s1, String s2) {
            int m = s1.length(), n = s2.length();
            int[][] f = new int[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        f[i][j] = f[i - 1][j - 1] + 1;
                    } else {
                        f[i][j] = Math.max(f[i - 1][j], f[i][j - 1]);
                    }
                }
            }
            return f[m][n];
        }
    }
}