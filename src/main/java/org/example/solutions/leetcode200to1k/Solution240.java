package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution240 {
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length, n = matrix[0].length;
            int r = 0, c = n - 1;
            while (r < m && c >= 0) {
                if (matrix[r][c] < target) r++;
                else if (matrix[r][c] > target) c--;
                else return true;
            }
            return false;
        }
    }
}