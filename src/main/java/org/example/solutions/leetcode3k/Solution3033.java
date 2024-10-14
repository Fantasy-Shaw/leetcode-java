package org.example.solutions.leetcode3k;

import java.util.Arrays;

public class Solution3033 {
    class Solution {
        public int[][] modifiedMatrix(int[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[] mx = new int[n];
            Arrays.fill(mx, -1);
            for (int j = 0; j < n; j++) {
                for (int i = 0; i < m; i++) {
                    mx[j] = Math.max(matrix[i][j], mx[j]);
                }
            }
            int[][] ans = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans[i][j] = (matrix[i][j] == -1) ? mx[j] : matrix[i][j];
                }
            }
            return ans;
        }
    }
}