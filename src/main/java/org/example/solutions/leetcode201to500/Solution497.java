package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution497 {
    class Solution {
        private Random rd;
        private int[][] rects;
        private int[] areaPrefixSum;

        private int n;

        public Solution(int[][] rects) {
            rd = new Random();
            this.rects = rects;
            n = rects.length;
            areaPrefixSum = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                areaPrefixSum[i] = areaPrefixSum[i - 1] + (rects[i - 1][2] - rects[i - 1][0] + 1) * (rects[i - 1][3] - rects[i - 1][1] + 1);
            }
        }

        public int[] pick() {
            int rdArea = rd.nextInt(areaPrefixSum[n]) + 1;
            int l = 0, r = n;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (areaPrefixSum[mid] >= rdArea) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            int[] rect = rects[r - 1];
            int a = rect[0], b = rect[1], x = rect[2], y = rect[3];
            return new int[]{a + rd.nextInt(x - a + 1), b + rd.nextInt(y - b + 1)};
        }
    }
}