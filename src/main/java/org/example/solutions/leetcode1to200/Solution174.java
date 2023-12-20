package org.example.solutions.leetcode1to200;

import java.util.Arrays;

public class Solution174 {
    class Solution1 {
        // backTrack + memorization
        private int rowSize = 0, colSize = 0;
        private int[][] dungeon = null;

        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
                return 0;
            }
            rowSize = dungeon.length;
            colSize = dungeon[0].length;
            this.dungeon = dungeon;
            int[][] memory = new int[rowSize][colSize];
            for (int i = 0; i < rowSize; i++) {
                Arrays.fill(memory[i], -1);
            }
            return dfs(0, 0, memory) + 1;
        }

        private int dfs(int rowIdx, int colIdx, int[][] memory) {
            if (rowIdx >= rowSize || colIdx >= colSize) {
                return Integer.MAX_VALUE;
            }
            if (memory[rowIdx][colIdx] != -1) {
                return memory[rowIdx][colIdx];
            }
            if (rowIdx == rowSize - 1 && colIdx == colSize - 1) {
                if (dungeon[rowIdx][colIdx] >= 0) {
                    return 0;
                } else {
                    return -dungeon[rowIdx][colIdx];
                }
            }
            int right = dfs(rowIdx, colIdx + 1, memory);
            int down = dfs(rowIdx + 1, colIdx, memory);
            int minReq = Math.min(right, down) - dungeon[rowIdx][colIdx];
            int res = Math.max(minReq, 0);
            memory[rowIdx][colIdx] = res;
            return res;
        }
    }

    class Solution {
        // dp
        public int calculateMinimumHP(int[][] dungeon) {
            if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
                return 0;
            }
            int rowSize = dungeon.length;
            int colSize = dungeon[0].length;
            int[][] dp = new int[rowSize][colSize];
            dp[rowSize - 1][colSize - 1] = Math.max(0, -dungeon[rowSize - 1][colSize - 1]);
            for (int i = rowSize - 2; i >= 0; i--) {
                int minReq = dp[i + 1][colSize - 1] - dungeon[i][colSize - 1];
                dp[i][colSize - 1] = Math.max(minReq, 0);
            }
            for (int i = colSize - 2; i >= 0; i--) {
                int minReq = dp[rowSize - 1][i + 1] - dungeon[rowSize - 1][i];
                dp[rowSize - 1][i] = Math.max(minReq, 0);
            }
            for (int i = rowSize - 2; i >= 0; i--) {
                for (int j = colSize - 2; j >= 0; j--) {
                    int minReq = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                    dp[i][j] = Math.max(minReq, 0);
                }
            }
            return dp[0][0] + 1;
        }
    }
}