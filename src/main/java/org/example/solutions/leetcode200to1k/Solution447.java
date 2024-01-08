package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution447 {
    class Solution {
        public int numberOfBoomerangs(int[][] points) {
            int ans = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < points.length; i++) {
                map.clear();
                for (int j = 0; j < points.length; j++) {
                    if (i == j) continue;
                    int x = points[i][0] - points[j][0], y = points[i][1] - points[j][1];
                    int d = x * x + y * y;
                    map.put(d, map.getOrDefault(d, 0) + 1);
                }
                for (var pair : map.entrySet()) {
                    var cur = pair.getValue();
                    ans += cur * (cur - 1);
                }
            }
            return ans;
        }
    }
}