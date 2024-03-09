package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution85 {
    class Solution {
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] onesLeft = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == '1') {
                        onesLeft[i][j] = (j == 0 ? 0 : onesLeft[i][j - 1]) + 1;
                    }
                }
            }
            int ans = 0;
            Deque<Integer> st = new ArrayDeque<>();
            for (int j = 0; j < n; j++) {
                st.clear();
                int[] up = new int[m], down = new int[m];
                for (int i = 0; i < m; i++) {
                    while (!st.isEmpty() && onesLeft[st.peek()][j] >= onesLeft[i][j]) {
                        st.pop();
                    }
                    up[i] = st.isEmpty() ? -1 : st.peek();
                    st.push(i);
                }
                st.clear();
                for (int i = m - 1; i >= 0; i--) {
                    while (!st.isEmpty() && onesLeft[st.peek()][j] >= onesLeft[i][j]) {
                        st.pop();
                    }
                    down[i] = st.isEmpty() ? m : st.peek();
                    st.push(i);
                }
                for (int i = 0; i < m; i++) {
                    ans = Math.max(ans, (down[i] - up[i] - 1) * onesLeft[i][j]);
                }
            }
            return ans;
        }
    }

    class Solution_BF {
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] sum = new int[m + 1][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int cur = matrix[i][j] == '1' ? 1 : 0;
                    sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] + cur - sum[i][j];
                }
            }
            int ans = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int x = 0; x < m; x++) {
                        for (int y = 0; y < n; y++) {
                            int ones = sum[x + 1][y + 1] - sum[x + 1][j] - sum[i][y + 1] + sum[i][j];
                            if (ones == (x - i + 1) * (y - j + 1)) {
                                ans = Math.max(ans, ones);
                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    class Solution_DP {
        public int maximalRectangle(char[][] matrix) {
            int m = matrix.length, n = matrix[0].length;
            int[][] heights = new int[m + 1][n + 1];
            int[][][] f = new int[m + 1][n + 1][m + 1];
            int ans = 0;
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int cur = matrix[i - 1][j - 1] == '1' ? 1 : 0;
                    if (cur == 0) {
                        continue;
                    }
                    heights[i][j] = heights[i - 1][j] + 1;
                    for (int k = 1; k <= heights[i][j]; k++) {
                        f[i][j][k] = f[i][j - 1][k] + k;
                        ans = Math.max(ans, f[i][j][k]);
                    }
                }
            }
            return ans;
        }
    }
}