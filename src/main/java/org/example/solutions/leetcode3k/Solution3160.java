package org.example.solutions.leetcode3k;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution3160 {
    /**
     * 1
     * [[0,2],[1,10],[0,10],[0,3],[1,5]]
     * [1,2,1,2,2]
     */
    class Solution {
        public int[] queryResults(int limit, int[][] queries) {
            Map<Integer, Integer> i2c = new HashMap<>();
            Map<Integer, Set<Integer>> c2i = new HashMap<>();
            int n = queries.length;
            int[] ans = new int[n];
            for (int i = 0; i < n; i++) {
                int x = queries[i][0];
                int y = queries[i][1];
                if (i2c.containsKey(x)) {
                    int pre = i2c.get(x);
                    var set = c2i.get(pre);
                    if (set.size() == 1) {
                        c2i.remove(pre);
                    } else {
                        set.remove(x);
                    }
                }
                i2c.put(x, y);
                c2i.computeIfAbsent(y, k -> new HashSet<>()).add(x);
                ans[i] = c2i.keySet().size();
            }
            return ans;
        }
    }
}