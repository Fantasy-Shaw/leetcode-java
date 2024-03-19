package org.example.solutions.leetcode1kto2k;

import org.example.templates.UnionFind;

public class Solution1579 {
    class Solution {
        public int maxNumEdgesToRemove(int n, int[][] edges) {
            UnionFind uf1 = new UnionFind(n), uf2 = new UnionFind(n);
            int ans = 0;
            for (var e : edges) {
                int type = e[0], x = e[1] - 1, y = e[2] - 1;
                if (type == 3) { // common
                    if (uf1.isConnected(x, y)) {
                        ans++;
                    } else {
                        uf1.union(x, y);
                        uf2.union(x, y);
                    }
                }
            }
            for (var e : edges) {
                int type = e[0], x = e[1] - 1, y = e[2] - 1;
                if (type == 1) { // common
                    if (!uf1.union(x, y)) {
                        ans++;
                    }
                } else if (type == 2) {
                    if (!uf2.union(x, y)) {
                        ans++;
                    }
                }
            }
            return uf1.getCount() == 1 && uf2.getCount() == 1 ? ans : -1;
        }
    }
}