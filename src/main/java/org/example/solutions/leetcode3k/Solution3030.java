package org.example.solutions.leetcode3k;

public class Solution3030 {
    class Solution {
        int[][] image;
        int threshold;

        public int[][] resultGrid(int[][] image, int threshold) {
            this.image = image;
            this.threshold = threshold;
            int m = image.length, n = image[0].length;
            int[][][] ans = new int[m][n][2];
            for (int i = 0; i < m - 2; i++) {
                for (int j = 0; j < n - 2; j++) {
                    int sum = 0;
                    for (int x = 0; x < 3; x++) {
                        for (int y = 0; y < 3; y++) {
                            sum += image[i + x][j + y];
                        }
                    }
                    if (isvalid(i, j)) {
                        int t = sum / 9;
                        for (int x = 0; x < 3; x++) {
                            for (int y = 0; y < 3; y++) {
                                ans[i + x][j + y][0] += t;
                                ans[i + x][j + y][1] += 1;
                            }
                        }
                    }
                }
            }
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (ans[i][j][1] == 0) {
                        res[i][j] = image[i][j];
                    } else {
                        res[i][j] = ans[i][j][0] / ans[i][j][1];
                    }
                }
            }
            return res;
        }

        private boolean isvalid(int x, int y) {
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int j = 0; j < 3; j++) {
                for (int i = 1; i < 3; i++) {
                    if (Math.abs(image[i + x - 1][j + y] - image[i + x][j + y]) > threshold) {
                        return false;
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 1; j < 3; j++) {
                    if (Math.abs(image[i + x][j + y - 1] - image[i + x][j + y]) > threshold) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
