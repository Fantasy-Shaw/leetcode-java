package org.example.templates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public
class LCA {
    private final int[] depth;
    private final int[][] parents;

    public LCA(int[][] edges) {
        int n = edges.length + 1;
        int m = 32 - Integer.numberOfLeadingZeros(n); // length of n in binary
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (var e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        depth = new int[n];
        parents = new int[n][m];
        for (var it : parents) {
            Arrays.fill(it, -1);
        }
        dfs(graph, 0, -1);
        for (int i = 0; i < m - 1; i++) {
            for (int x = 0; x < n; x++) {
                int p = parents[x][i];
                parents[x][i + 1] = p < 0 ? -1 : parents[p][i];
            }
        }
    }

    private void dfs(List<List<Integer>> graph, int x, int parent) {
        parents[x][0] = parent;
        for (int y : graph.get(x)) {
            if (y != parent) {
                depth[y] = depth[x] + 1;
                dfs(graph, y, x);
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for (; k > 0 && node != -1; k &= k - 1) {
            node = parents[node][Integer.numberOfTrailingZeros(k)];
        }
        return node;
    }

    public int getLCA(int x, int y) {
        if (depth[x] > depth[y]) {
            int t = x;
            x = y;
            y = t;
        }
        y = getKthAncestor(y, depth[y] - depth[x]);
        if (y == x) {
            return x;
        }
        for (int i = parents[x].length - 1; i >= 0; i--) {
            int px = parents[x][i];
            int py = parents[y][i];
            if (px != py) {
                x = px;
                y = py;
            }
        }
        return parents[x][0];
    }
}
