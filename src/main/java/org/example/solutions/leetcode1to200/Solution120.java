package org.example.solutions.leetcode1to200;

import java.util.*;

public class Solution120 {
    class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            Map<Long, Integer> memo = new HashMap<>();
            return dfs(triangle, 0, 0, memo);
        }

        private int dfs(List<List<Integer>> triangle, int i, int j, Map<Long, Integer> memo) {
            if (i >= triangle.size() || j >= triangle.get(i).size() || j < 0) return 0;
            long k = (long) i << 32 | j;
            if (memo.containsKey(k)) return memo.get(k);
            int ans = triangle.get(i).get(j)
                    + Math.min(dfs(triangle, i + 1, j, memo), dfs(triangle, i + 1, j + 1, memo));
            memo.put(k, ans);
            return ans;
        }
    }
}