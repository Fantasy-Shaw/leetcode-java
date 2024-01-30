package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1620 {
    class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            Arrays.sort(towers, (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0]);
            double mx = -1;
            int x = 0, y = 0;
            for (int x1 = 105; x1 >= 0; x1--) {
                for (int y1 = 105; y1 >= 0; y1--) {
                    int cur = 0;
                    for (int[] tower : towers) {
                        int x2 = tower[0], y2 = tower[1], q = tower[2];
                        int d = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
                        if (d <= radius * radius) {
                            cur += (int) (q / (1 + Math.sqrt(d)));
                        }
                    }
                    if (cur >= mx) {
                        x = x1;
                        y = y1;
                        mx = cur;
                    }
                }
            }
            return new int[]{x, y};
        }
    }
}