package org.example.solutions.leetcode501to1k;

import org.example.templates.UnionFind;

public class Solution785 {
    class Solution {
        public boolean isBipartite(int[][] graph) {
            UnionFind uf = new UnionFind(graph.length);
            for (int i = 0; i < graph.length; i++) {
                int[] nbs = graph[i];
                for (int nb : nbs) {
                    if (uf.isConnected(i, nb)) {
                        return false;
                    }
                    uf.union(nbs[0], nb);
                }
            }
            return true;
        }
    }
}