package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1615 {
    class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            int[] deg = new int[n];
            List<HashSet<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new HashSet<>());
            }
            for (int[] road : roads) {
                deg[road[0]]++;
                deg[road[1]]++;
                graph.get(road[0]).add(road[1]);
                graph.get(road[1]).add(road[0]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int cur = deg[i] + deg[j];
                    if (graph.get(i).contains(j)) {
                        cur--;
                    }
                    ans = Math.max(ans, cur);
                }
            }
            return ans;
        }
    }
}