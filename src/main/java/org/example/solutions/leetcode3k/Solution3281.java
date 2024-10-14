package org.example.solutions.leetcode3k;

import java.util.Arrays;
import java.util.Comparator;

public class Solution3281 {
    class Solution {
        public int maxPossibleScore(int[] start, int d) {
            int[][] arr = new int[start.length][];
            for (int i = 0; i < start.length; i++) {
                arr[i] = new int[]{start[i], start[i] + d};
            }
            Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
            long l = Long.MAX_VALUE / 2;
            for (int i = 1; i < arr.length; i++) {
                int[] x = arr[i - 1];
                int[] y = arr[i];
                l = Math.min(l, y[0] - x[1]);
            }
            long r = Long.MAX_VALUE / 2;
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (isValid(arr, mid)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return (int) (l - 1); // upper_bound - 1
        }

        private boolean isValid(int[][] arr, long score) {
            long x = arr[0][0];
            for (int i = 1; i < arr.length; i++) {
                if (x + score > arr[i][1]) return false;
                x = Math.max(x + score, arr[i][0]);
            }
            return true;
        }
    }
}