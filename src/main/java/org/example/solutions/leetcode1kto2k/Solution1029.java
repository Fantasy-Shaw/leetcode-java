package org.example.solutions.leetcode1kto2k;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1029 {
    class Solution {
        public int twoCitySchedCost(int[][] costs) {
            int n = costs.length / 2;
            Arrays.sort(costs, Comparator.comparingInt(a -> (a[0] - a[1])));
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += costs[i][0];
            }
            for (int i = n; i < costs.length; i++) {
                ans += costs[i][1];
            }
            return ans;
        }
    }
}