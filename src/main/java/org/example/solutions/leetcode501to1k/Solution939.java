package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution939 {
    class Solution {
        public int minAreaRect(int[][] points) {
            if (points.length < 4) {
                return 0;
            }
            Arrays.sort(points, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            Map<Integer, List<List<int[]>>> map = new HashMap<>();
            int n = points.length, ans = Integer.MAX_VALUE;
            for (int i = 0; i < n - 1; i++) {
                int[] a = points[i];
                for (int j = i + 1; j < n; j++) {
                    int[] b = points[j];
                    if (a[0] == b[0]) {
                        int key = a[1] * 40005 + b[1];
                        map.putIfAbsent(key, new ArrayList<>());
                        map.get(key).add(List.of(a, b));
                    }
                }
            }
            for (var it : map.entrySet()) {
                var list = it.getValue();
                int m = list.size();
                if (m == 1) {
                    continue;
                }
                for (int i = 0; i < m - 1; i++) {
                    int[] a = list.get(i).getFirst(), b = list.get(i).getLast();
                    for (int j = i + 1; j < m; j++) {
                        int[] c = list.get(j).getFirst(), d = list.get(j).getLast();
                        int x = Math.abs(a[1] - b[1]), y = Math.abs(c[0] - a[0]);
                        ans = Math.min(ans, x * y);
                    }
                }
            }
            return ans < Integer.MAX_VALUE ? ans : 0;
        }
    }
}