package org.example.solutions.leetcode2k;

public class Solution2132 {
    private class Solution {
        public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
            int m = grid.length, n = grid[0].length;
            // 1. prefix 2d
            int[][] prefix = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    prefix[i + 1][j + 1] = prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j] + grid[i][j];
                }
            }
            // 2. diff 2d
            int[][] diff = new int[m + 2][n + 2];
            for (int i = stampHeight; i <= m; i++) {
                for (int j = stampWidth; j <= n; j++) {
                    int x = i - stampHeight + 1;
                    int y = j - stampWidth + 1;
                    boolean isBlank = (prefix[i][j] - prefix[x - 1][j] - prefix[i][y - 1] + prefix[x - 1][y - 1] == 0);
                    if (isBlank) {
                        diff[x][y]++;
                        diff[x][j + 1]--;
                        diff[i + 1][y]--;
                        diff[i + 1][j + 1]++;
                    }
                }
            }
            // 3. diff -> count
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    diff[i + 1][j + 1] += (diff[i][j + 1] + diff[i + 1][j] - diff[i][j]);
                    if (grid[i][j] == 0 && diff[i + 1][j + 1] == 0) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
