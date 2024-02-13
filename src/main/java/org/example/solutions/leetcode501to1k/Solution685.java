package org.example.solutions.leetcode501to1k;

import org.example.templates.UnionFind;

import java.util.*;

public class Solution685 {
    class Solution {
        private static final int maxN = 1010;
        private int[][] edges;

        public int[] findRedundantDirectedConnection(int[][] edges) {
            this.edges = edges;
            int[] inDegrees = new int[maxN];
            for (int[] edge : edges) {
                inDegrees[edge[1]]++;
            }
            List<Integer> nodesWithDeg2 = new ArrayList<>();
            for (int i = edges.length - 1; i >= 0; i--) {
                if (inDegrees[edges[i][1]] == 2) {
                    nodesWithDeg2.add(i);
                }
            }
            if (!nodesWithDeg2.isEmpty()) {
                if (isATree(nodesWithDeg2.get(0))) {
                    return edges[nodesWithDeg2.get(0)];
                } else {
                    return edges[nodesWithDeg2.get(1)];
                }
            }
            return getRmEdgeFromCircle();
        }

        private boolean isATree(int rmEdgeIdx) {
            UnionFind uf = new UnionFind(maxN);
            for (int i = 0; i < edges.length; i++) {
                if (i == rmEdgeIdx) {
                    continue;
                }
                if (!uf.union(edges[i][0], edges[i][1])) {
                    return false;
                }
            }
            return true;
        }

        private int[] getRmEdgeFromCircle() {
            UnionFind uf = new UnionFind(maxN);
            for (int[] edge : edges) {
                if (!uf.union(edge[0], edge[1])) {
                    return edge;
                }
            }
            return new int[0];
        }
    }
}