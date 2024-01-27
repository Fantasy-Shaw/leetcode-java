package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2846 {
    class Solution {
        List<List<int[]>> graph;
        int[][] pa;
        int[][][] cnt;
        int[] depth;

        public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
            graph = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            for (int[] e : edges) {
                int x = e[0], y = e[1], w = e[2] - 1;
                graph.get(x).add(new int[]{y, w});
                graph.get(y).add(new int[]{x, w});
            }
            int m = 32 - Integer.numberOfLeadingZeros(n);
            pa = new int[n][m];
            for (var it : pa) {
                Arrays.fill(it, -1);
            }
            cnt = new int[n][m][26];
            depth = new int[n];
            dfs(0, -1);
            for (int i = 0; i < m - 1; i++) {
                for (int x = 0; x < n; x++) {
                    int p = pa[x][i];
                    if (p != -1) {
                        int pp = pa[p][i];
                        pa[x][i + 1] = pp;
                        for (int j = 0; j < 26; j++) {
                            cnt[x][i + 1][j] = cnt[x][i][j] + cnt[p][i][j];
                        }
                    }
                }
            }
            int[] ans = new int[queries.length];
            for (int qi = 0; qi < queries.length; qi++) {
                int x = queries[qi][0], y = queries[qi][1];
                int pathLen = depth[x] + depth[y];
                int[] cw = new int[26];
                if (depth[x] > depth[y]) {
                    int t = x;
                    x = y;
                    y = t;
                }
                for (int k = depth[y] - depth[x]; k > 0; k &= k - 1) {
                    int i = Integer.numberOfTrailingZeros(k);
                    int p = pa[y][i];
                    for (int j = 0; j < 26; j++) {
                        cw[j] += cnt[y][i][j];
                    }
                    y = p;
                }
                if (y != x) {
                    for (int i = m - 1; i >= 0; i--) {
                        int px = pa[x][i];
                        int py = pa[y][i];
                        if (px != py) {
                            for (int j = 0; j < 26; j++) {
                                cw[j] += cnt[x][i][j] + cnt[y][i][j];
                            }
                            x = px;
                            y = py;
                        }
                    }
                    for (int j = 0; j < 26; j++) {
                        cw[j] += cnt[x][0][j] + cnt[y][0][j];
                    }
                    x = pa[x][0];
                }
                int lca = x;
                pathLen -= depth[lca] * 2;
                int maxCw = 0;
                for (int i = 0; i < 26; i++) {
                    maxCw = Math.max(maxCw, cw[i]);
                }
                ans[qi] = pathLen - maxCw;
            }
            return ans;
        }

        private void dfs(int x, int fa) {
            pa[x][0] = fa;
            for (var p : graph.get(x)) {
                int y = p[0], w = p[1];
                if (y != fa) {
                    cnt[y][0][w] = 1;
                    depth[y] = depth[x] + 1;
                    dfs(y, x);
                }
            }
        }
    }
}