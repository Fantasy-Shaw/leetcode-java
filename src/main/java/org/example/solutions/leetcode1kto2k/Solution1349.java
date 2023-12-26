package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1349 {
    class Solution {
        public int maxStudents(char[][] seats) {
            int m = seats.length, n = seats[0].length;
            int[] a = new int[m];   // Available seats in i-th rows.
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (seats[i][j] == '.') {
                        a[i] |= 1 << j;
                    }
                }
            }
            int[][] memo = new int[m][1 << n];
            for (int[] row : memo) {
                Arrays.fill(row, -1);
            }
            return dfs(m - 1, a[m - 1], memo, a);
        }

        private int dfs(int i, int j, int[][] memo, int[] a) {
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            if (i == 0) {
                if (j == 0) { // boundary
                    return 0;
                }
                int lb = j & -j;
                memo[i][j] = dfs(i, (j & ~(lb << 1 | lb)), memo, a) + 1;
                return memo[i][j];
            }
            int res = dfs(i - 1, a[i - 1], memo, a); // i-th row is empty
            for (int s = j; s > 0; s = (s - 1) & j) {
                if ((s & (s >> 1)) == 0) { // No continual '1's
                    int t = a[i - 1] & ~(s << 1 | s >> 1);
                    res = Math.max(res, dfs(i - 1, t, memo, a) + Integer.bitCount(s));
                }
            }
            memo[i][j] = res;
            return res;
        }
    }
}