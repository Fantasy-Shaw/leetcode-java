package org.example.solutions.leetcode1kto2k;

import org.example.templates.UnionFind;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution1168 {
    class Solution {
        /**
         * Kruskal
         * 超级源点
         * 至少有1口井，所有村子要联通
         * 把地下水看作是1个节点，打井的代价看作是和这个节点的边的权值
         */
        public int minCostToSupplyWater(int n, int[] wells, int[][] pipes) {
            List<int[]> edges = new ArrayList<>(Arrays.asList(pipes));
            for (int i = 0; i < n; i++) {
                edges.add(new int[]{i + 1, n + 1, wells[i]});
            }
            edges.sort(Comparator.comparingInt(value -> value[2]));
            int ans = 0;
            UnionFind uf = new UnionFind(n + 10);
            for (var edge : edges) {
                if (uf.union(edge[0], edge[1])) {
                    ans += edge[2];
                }
            }
            return ans;
        }
    }
}