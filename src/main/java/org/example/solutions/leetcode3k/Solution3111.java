package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3111 {
    class Solution {
        public int minRectanglesToCoverPoints(int[][] points, int w) {
            Arrays.sort(points, (a, b) -> a[0] - b[0]);
            int pre = Integer.MIN_VALUE / 2, ans = 0;
            for (var it : points) {
                if (it[0] - pre > w) {
                    pre = it[0];
                    ans++;
                }
            }
            return ans;
        }
    }
}