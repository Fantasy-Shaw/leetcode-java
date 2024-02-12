package org.example.solutions.leetcode200to1k;

import org.example.templates.MultiSet;

import java.util.*;

public class Solution218 {
    class Solution {
        private static final int LEFT = -1, RIGHT = 1;

        public List<List<Integer>> getSkyline(int[][] buildings) {
            List<List<Integer>> ans = new ArrayList<>();
            List<int[]> ps = new ArrayList<>();
            for (int[] b : buildings) {
                int l = b[0], r = b[1], h = b[2];
                ps.add(new int[]{l, h, LEFT});
                ps.add(new int[]{r, h, RIGHT});
            }
            ps.sort((a, b) -> {
                if (a[0] != b[0]) return a[0] - b[0];
                if (a[2] != b[2]) return a[2] - b[2];
                if (a[2] == LEFT) {
                    return b[1] - a[1];
                } else {
                    return a[1] - b[1];
                }
            });
            MultiSet<Integer> pq = new MultiSet<>(Collections.reverseOrder());
            int prev = 0;
            pq.add(prev);
            for (int[] p : ps) {
                int point = p[0], h = p[1], f = p[2];
                if (f == LEFT) {
                    pq.add(h);
                } else {
                    pq.remove(h);
                }
                int cur = pq.peekFirst();
                if (cur != prev) {
                    ans.add(List.of(point, cur));
                    prev = cur;
                }
            }
            return ans;
        }
    }
}