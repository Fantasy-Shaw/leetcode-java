package org.example.solutions.leetcode200to1k;

public class Solution251 {
    class Vector2D {
        int n, curIdx, curRow;
        int[][] vec;

        public Vector2D(int[][] vec) {
            curIdx = 0;
            curRow = 0;
            n = vec.length;
            while (curRow < n && vec[curRow].length == 0) {
                curRow++;
            }
            this.vec = vec;
        }

        public int next() {
            if (curIdx < vec[curRow].length) {
                return vec[curRow][curIdx++];
            } else {
                curRow++;
                curIdx = 0;
                while (curRow < n && vec[curRow].length == 0) {
                    curRow++;
                }
                return vec[curRow][curIdx++];
            }
        }

        public boolean hasNext() {
            if (curRow >= n) {
                return false;
            }
            if (curIdx < vec[curRow].length) {
                return true;
            } else {
                int nextRow = curRow + 1;
                while (nextRow < n && vec[nextRow].length == 0) {
                    nextRow++;
                }
                return nextRow < n;
            }
        }
    }
}