package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution832 {
    class Solution {
        public int[][] flipAndInvertImage(int[][] image) {
            int n = image.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0, m = (n + 1)/ 2; j < m; j++) {
                    int t = (~image[i][j]) & 1;
                    image[i][j] = (~image[i][n - j - 1]) & 1;
                    image[i][n - j - 1] = t;
                }
            }
            return image;
        }
    }
}