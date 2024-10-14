package org.example.solutions.leetcode1kto2k;

import org.example.templates.UnionFind;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1135 {
    class Solution {
        //Kruskal
        public int minimumCost(int n, int[][] connections) {
            UnionFind uf = new UnionFind(n);
            Arrays.sort(connections, Comparator.comparingInt(a -> a[2]));
            int cost = 0;
            for (var edge : connections) {
                if (uf.union(edge[0] - 1, edge[1] - 1)) {
                    cost += edge[2];
                }
            }
            return uf.getCount() == 1 ? cost : -1;
        }
    }
}