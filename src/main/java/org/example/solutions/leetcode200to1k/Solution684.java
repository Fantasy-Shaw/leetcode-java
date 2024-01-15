package org.example.solutions.leetcode200to1k;

import org.example.templates.UnionFind;

public class Solution684 {
    class Solution {
        private static final int maxN = 1010;

        public int[] findRedundantConnection(int[][] edges) {
            UnionFind uf = new UnionFind(maxN);
            int[] edgeToDel = null;
            for (int[] edge : edges) {
                if (!uf.union(edge[0], edge[1])) {
                    edgeToDel = edge;
                }
            }
            return edgeToDel;
        }
    }
}