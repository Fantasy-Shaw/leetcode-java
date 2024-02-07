package org.example.solutions.leetcode1kto2k;

public class Solution1240 {
    class Solution {
        int[][] covered;
        int ans;

        public int tilingRectangle(int n, int m) {
            if (n == m) {
                return 1;
            }
            covered = new int[n][m];
            ans = n * m;
            dfs(n, m, 0);
            return ans;
        }

        private void dfs(int n, int m, int cur) {
            if (cur >= ans) {
                return;
            }
            boolean isFull = true;
            int x = 0, y = 0;
            loopFull:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (covered[i][j] == 0) {
                        isFull = false;
                        x = i;
                        y = j;
                        break loopFull;
                    }
                }
            }
            if (isFull) {
                ans = Math.min(ans, cur);
                return;
            }
            for (int k = Math.min(n - x, m - y); k >= 1; k--) {
                boolean isEmpty = true;
                loopEmpty:
                for (int i = x; i < x + k; i++) {
                    for (int j = y; j < y + k; j++) {
                        if (covered[i][j] == 1) {
                            isEmpty = false;
                            break loopEmpty;
                        }
                    }
                }
                if (!isEmpty) {
                    continue;
                }
                for (int i = x; i < x + k; i++) {
                    for (int j = y; j < y + k; j++) {
                        covered[i][j] = 1;
                    }
                }
                dfs(n, m, cur + 1);
                for (int i = x; i < x + k; i++) {
                    for (int j = y; j < y + k; j++) {
                        covered[i][j] = 0;
                    }
                }
            }
        }
    }
}