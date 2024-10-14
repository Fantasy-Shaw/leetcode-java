package org.example.solutions.leetcode2k;

public class Solution2397 {
    class Solution {
        public int maximumRows(int[][] matrix, int numSelect) {
            int m = matrix.length, n = matrix[0].length;
            int[] mask = new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    mask[i] |= matrix[i][j] << j;
                }
            }
            int ans = 0;
            for (int s = 0; s < (1 << n); s++) {
                if (Integer.bitCount(s) == numSelect) {
                    int coverNums = 0;
                    for (int row : mask) {
                        if ((row & s) == row) {
                            coverNums++;
                        }
                    }
                    ans = Math.max(ans, coverNums);
                }
            }
            return ans;
        }
    }
}