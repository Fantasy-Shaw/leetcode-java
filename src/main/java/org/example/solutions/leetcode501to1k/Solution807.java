package org.example.solutions.leetcode501to1k;

public class Solution807 {
    class Solution {
        public int maxIncreaseKeepingSkyline(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            int[] maxM = new int[m], maxN = new int[n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    maxM[i] = Math.max(maxM[i], grid[i][j]);
                    maxN[j] = Math.max(maxN[j], grid[i][j]);
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    ans += Math.max(0, Math.min(maxM[i], maxN[j]) - grid[i][j]);
                }
            }
            return ans;
        }
    }
}