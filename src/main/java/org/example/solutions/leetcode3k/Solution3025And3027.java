package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3025And3027 {
    class Solution {
        public int numberOfPairs(int[][] points) {
            Arrays.sort(points, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
            int ans = 0;
            for (int i = 0; i < points.length; i++) {
                int y0 = points[i][1];
                int maxY = Integer.MIN_VALUE;
                for (int j = i + 1; j < points.length; j++) {
                    int y = points[j][1];
                    if (y <= y0 && y > maxY) {
                        maxY = y;
                        ans++;
                    }
                }
            }
            return ans;
        }
    }
}