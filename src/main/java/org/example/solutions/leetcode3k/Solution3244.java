package org.example.solutions.leetcode3k;

import org.example.templates.UnionFind;

public class Solution3244 {
    class Solution {
        public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
            UnionFind uf = new UnionFind(n);
            int m = queries.length;
            int[] ans = new int[m];
            for (int i = 0; i < m; i++) {
                int l = queries[i][0];
                int r = queries[i][1] - 1;
                int k = uf.find(r);
                for (int j = uf.find(l); j < r; j = uf.find(j + 1)) {
                    uf.union(j, k);
                }
                ans[i] = uf.getCount() - 1;
            }
            return ans;
        }
    }
}