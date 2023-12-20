package org.example.solutions.leetcode1kto2k;

public class Solution1901 {
    class Solution {
        public int[] findPeakGrid(int[][] mat) {
            int left = 0, right = mat.length - 1;
            while (left < right) {
                int i = (left + right) / 2;
                int j = idxOfMaxElem(mat[i]);
                if (mat[i][j] > mat[i + 1][j]) {
                    right = i;
                } else {
                    left = i + 1;
                }
            }
            return new int[]{left, idxOfMaxElem(mat[left])};
        }

        private int idxOfMaxElem(int[] arr) {
            int idx = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > arr[idx]) {
                    idx = i;
                }
            }
            return idx;
        }
    }
}