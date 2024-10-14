package org.example.solutions.leetcode2k;

import java.util.HashMap;
import java.util.Map;

public class Solution2312 {
    class Solution {
        public long sellingWood(int m, int n, int[][] prices) {
            // long: pair<int,int>
            Map<Long, Integer> shape2price = new HashMap<>();
            for (var p : prices) {
                shape2price.put((long) p[0] << 32 | p[1], p[2]);
            }
            long[][] f = new long[m + 1][n + 1];
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    f[i][j] = shape2price.getOrDefault((long) i << 32 | j, 0);
                    for (int k = 1; k < i; k++) {
                        f[i][j] = Math.max(f[i][j], f[k][j] + f[i - k][j]);
                    }
                    for (int k = 1; k < j; k++) {
                        f[i][j] = Math.max(f[i][j], f[i][k] + f[i][j - k]);
                    }
                }
            }
            return f[m][n];
        }
    }
}