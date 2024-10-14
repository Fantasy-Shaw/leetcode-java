package org.example.solutions.leetcode1to200;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution56 {
    class Solution {
        public int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            List<int[]> ans = new ArrayList<>();
            for (int[] pair : intervals) {
                if (ans.isEmpty() || ans.getLast()[1] < pair[0]) {
                    ans.add(pair);
                } else {
                    ans.getLast()[1] = Math.max(ans.getLast()[1], pair[1]);
                }
            }
            return ans.toArray(new int[ans.size()][]);
        }
    }
}