package org.example.solutions.leetcode201to500;

public class Solution363 {
    class Solution1 { // 二维前缀和
        public int maxSumSubmatrix(int[][] matrix, int k) {
            int m = matrix.length, n = matrix[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
                }
            }
            int ans = Integer.MIN_VALUE;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    for (int p = i; p <= m; p++) {
                        for (int q = j; q <= n; q++) {
                            int cur = sum[p][q] - sum[i - 1][q] - sum[p][j - 1] + sum[i - 1][j - 1];
                            if (cur <= k) {
                                ans = Math.max(ans, cur);
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }
}