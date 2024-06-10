package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3169 {
    class Solution {
        public int countDays(int days, int[][] meetings) {
            List<int[]> intervals = new ArrayList<>();
            Arrays.sort(meetings, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            for (var it : meetings) {
                if (intervals.isEmpty() || it[0] > intervals.getLast()[1] + 1) {
                    intervals.add(it);
                } else {
                    var pre = intervals.removeLast();
                    intervals.add(new int[]{pre[0], Math.max(it[1], pre[1])});
                }
            }
            int ans = days;
            for (var it : intervals) {
                ans -= (it[1] - it[0] + 1);
            }
            return ans;
        }
    }
}