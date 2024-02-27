package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution474 {
    class Solution {
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] cnt = new int[strs.length][2];
            for (int i = 0; i < strs.length; i++) {
                for (int j = 0; j < strs[i].length(); j++) {
                    if (strs[i].charAt(j) == '0') {
                        cnt[i][0]++;
                    } else {
                        cnt[i][1]++;
                    }
                }
            }
            // dp[k][i][j] : max value of 0~k-th objs with 0's <=i and 1's <=j
            int[][][] dp = new int[strs.length][m + 1][n + 1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    dp[0][i][j] = (cnt[0][0] <= i && cnt[0][1] <= j) ? 1 : 0;
                }
            }
            for (int k = 1; k < strs.length; k++) {
                int x = cnt[k][0], y = cnt[k][1];
                for (int i = 0; i <= m; i++) {
                    for (int j = 0; j <= n; j++) {
                        // without the k-th selected
                        int a = dp[k - 1][i][j];
                        // with the k-th selected if volume available
                        int b = (i >= x && j >= y) ? dp[k - 1][i - x][j - y] + 1 : 0;
                        dp[k][i][j] = Math.max(a, b);
                    }
                }
            }
            return dp[strs.length - 1][m][n];
        }
    }
}