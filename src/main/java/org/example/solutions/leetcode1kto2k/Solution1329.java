package org.example.solutions.leetcode1kto2k;

import java.util.PriorityQueue;

public class Solution1329 {
    class Solution {
        private static final PriorityQueue<Integer> pq = new PriorityQueue<>();

        public int[][] diagonalSort(int[][] mat) {
            for (int i = 0; i < mat.length; i++) {
                sort(mat, i, 0);
            }
            for (int j = 1; j < mat[0].length; j++) {
                sort(mat, 0, j);
            }
            return mat;
        }

        private static void sort(int[][] mat, int x, int y) {
            for (int i = x, j = y; i < mat.length && j < mat[0].length; i++, j++) {
                pq.offer(mat[i][j]);
            }
            for (int i = x, j = y; i < mat.length && j < mat[0].length; i++, j++) {
                mat[i][j] = pq.poll();
            }
        }
    }
}