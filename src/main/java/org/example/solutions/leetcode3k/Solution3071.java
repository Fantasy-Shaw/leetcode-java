package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3071 {
    class Solution {
        public int minimumOperationsToWriteY(int[][] grid) {
            int[] cnt_y = new int[3];
            int[] cnt_ny = new int[3];
            int n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isY(i, j, n)) {
                        cnt_y[grid[i][j]]++;
                    } else {
                        cnt_ny[grid[i][j]]++;
                    }
                }
            }
            int sum_y = Arrays.stream(cnt_y).sum();
            int sum_ny = Arrays.stream(cnt_ny).sum();
            List<int[]> ys = new ArrayList<>(), nys = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                ys.add(new int[]{i, cnt_y[i]});
                nys.add(new int[]{i, cnt_ny[i]});
            }
            ys.sort(Comparator.comparingInt(a -> -a[1]));
            nys.sort(Comparator.comparingInt(a -> -a[1]));
            if (ys.getFirst()[0] != nys.getFirst()[0]) {
                return sum_y - ys.getFirst()[1] + sum_ny - nys.getFirst()[1];
            } else {
                return Math.min(
                        sum_y - ys.getFirst()[1] + sum_ny - nys.get(1)[1],
                        sum_y - ys.get(1)[1] + sum_ny - nys.getFirst()[1]
                );
            }
        }

        private boolean isY(int i, int j, int n) {
            return (i == j && i <= n / 2) || (i == (n - j - 1) && i <= n / 2) || (j == n / 2 && i > n / 2);
        }
    }
}