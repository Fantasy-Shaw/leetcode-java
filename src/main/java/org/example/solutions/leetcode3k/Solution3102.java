package org.example.solutions.leetcode3k;

import org.example.templates.MultiSet;

public class Solution3102 {
    class Solution {
        public int minimumDistance(int[][] points) {
            MultiSet<Integer> xs = new MultiSet<>(), ys = new MultiSet<>();
            for (var p : points) {
                xs.add(p[0] + p[1]);
                ys.add(p[1] - p[0]);
            }
            int ans = Integer.MAX_VALUE;
            for (var p : points) {
                int x = p[0] + p[1], y = p[1] - p[0];
                xs.remove(x);
                ys.remove(y);
                ans = Math.min(ans, Math.max(xs.peekLast() - xs.peekFirst(), ys.peekLast() - ys.peekFirst()));
                xs.add(x);
                ys.add(y);
            }
            return ans;
        }
    }
}