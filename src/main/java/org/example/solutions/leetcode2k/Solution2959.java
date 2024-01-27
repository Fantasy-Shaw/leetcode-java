package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2959 {
    class Solution {
        static final int inf = Integer.MAX_VALUE / 2;

        public int numberOfSets(int n, int maxDistance, int[][] roads) {
            int[][] oldG = new int[n][n], newG = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(oldG[i], inf);
                oldG[i][i] = 0;
            }
            for (var e : roads) {
                int x = e[0], y = e[1], w = e[2];
                oldG[x][y] = oldG[y][x] = Math.min(oldG[x][y], w);
            }
            int ans = 0;
            next:
            for (int s = 0, m = (1 << n); s < m; s++) {
                for (int i = 0; i < n; i++) {
                    if ((s >> i & 1) == 1) {
                        newG[i] = oldG[i].clone();
                    }
                }
                // Floyd
                for (int k = 0; k < n; k++) {
                    if ((s >> k & 1) == 0) continue;
                    for (int i = 0; i < n; i++) {
                        if ((s >> i & 1) == 0) continue;
                        for (int j = 0; j < n; j++) {
                            newG[i][j] = Math.min(newG[i][j], newG[i][k] + newG[k][j]);
                        }
                    }
                }
                for (int i = 0; i < n; i++) {
                    if ((s >> i & 1) == 0) continue;
                    for (int j = 0; j < n; j++) {
                        if ((s >> j & 1) == 1 && newG[i][j] > maxDistance) {
                            continue next;
                        }
                    }
                }
                ans++;
            }
            return ans;
        }
    }
}