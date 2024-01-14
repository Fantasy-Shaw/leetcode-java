package org.example.solutions.leetcode200to1k;

import org.example.templates.UnionFind;

import java.util.*;

public class Solution261 {
    class Solution {
        public boolean validTree(int n, int[][] edges) {
            // 无环图的连通分量为1，是树
            UnionFind uf = new UnionFind(n);
            for (int[] edge : edges) {
                if (!uf.union(edge[0], edge[1])) { // 有环
                    return false;
                }
            }
            return uf.getCount() == 1;
        }
    }
}