package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3143 {
    class Solution {
        static class Point {
            public int i;
            public int[] pos;

            public Point(int i, int[] pos) {
                this.i = i;
                this.pos = pos;
            }
        }

        public int maxPointsInsideSquare(int[][] points, String s) {
            List<Point> pointList = new ArrayList<>();
            int n = points.length;
            for (int i = 0; i < n; i++) {
                pointList.add(new Point(i, points[i]));
            }
            pointList.sort(Comparator.comparingInt(a -> Math.max(Math.abs(a.pos[0]), Math.abs(a.pos[1]))));
            int l = 0, r = Math.max(Math.abs(pointList.getLast().pos[0]), Math.abs(pointList.getLast().pos[1])) + 1;
            int ans = 0;
            while (l < r) {
                int mid = l + (r - l) / 2;
                int cur = isValid(mid, pointList, s);
                if (cur != -1) {
                    l = mid + 1;
                    ans = cur;
                } else {
                    r = mid;
                }
            }
            return ans;
        }

        private int isValid(int x, List<Point> pointList, String s) {
            int ans = 0;
            boolean[] visited = new boolean[26];
            for (var p : pointList) {
                if (Math.max(Math.abs(p.pos[0]), Math.abs(p.pos[1])) > x) break;
                char ch = s.charAt(p.i);
                if (visited[ch - 'a']) return -1;
                visited[ch - 'a'] = true;
                ans++;
            }
            return ans;
        }
    }
}