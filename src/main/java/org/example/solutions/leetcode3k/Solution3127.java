package org.example.solutions.leetcode3k;

public class Solution3127 {
    class Solution {
        public boolean canMakeSquare(char[][] grid) {
            if (contains(grid)) return true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = grid[i][j];
                    grid[i][j] = (c == 'B') ? 'W' : 'B';
                    if (contains(grid)) return true;
                    grid[i][j] = c;
                }
            }
            return false;
        }

        private boolean contains(char[][] grid) {
            for (int i = 0; i <= 1; i++) {
                for (int j = 0; j <= 1; j++) {
                    if (grid[i][j] == 'B' && grid[i + 1][j] == 'B' && grid[i][j + 1] == 'B' && grid[i + 1][j + 1] == 'B') {
                        return true;
                    }
                    if (grid[i][j] == 'W' && grid[i + 1][j] == 'W' && grid[i][j + 1] == 'W' && grid[i + 1][j + 1] == 'W') {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}