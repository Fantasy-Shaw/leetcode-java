package org.example.solutions.leetcode1kto2k;

public class Solution1049 {
    class Solution {
        /**
         * Leetcode-494, MAX(target) <= sum / 2;
         * 0-1 Package
         */
        public int lastStoneWeightII(int[] stones) {
            int n = stones.length;
            int sum = 0;
            for (int i : stones) {
                sum += i;
            }
            int target = sum / 2;
            int[][] f = new int[n + 1][target + 1];
            for (int i = 1; i <= n; i++) {
                int x = stones[i - 1];
                for (int j = 0; j <= target; j++) {
                    f[i][j] = f[i - 1][j];
                    if (j - x >= 0) {
                        f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + x);
                    }
                }
            }
            return Math.abs(sum - 2 * f[n][target]);
        }
    }
}