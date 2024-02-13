package org.example.solutions.leetcode501to1k;

public class Solution566 {
    class Solution {
        public int[][] matrixReshape(int[][] mat, int r, int c) {
            if (mat.length * mat[0].length != r * c) return mat;
            int[][] ans = new int[r][c];
            int k = 0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat[0].length; j++) {
                    ans[k / c][k % c] = mat[i][j];
                    k++;
                }
            }
            return ans;
        }
    }
}