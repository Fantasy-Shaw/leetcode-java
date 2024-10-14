package org.example.solutions.leetcode1kto2k;

import java.util.Arrays;
import java.util.Comparator;

public class Solution1235 {
    class Solution {
        public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
            int n = startTime.length;
            int[][] jobs = new int[n][];
            for (int i = 0; i < n; i++) {
                jobs[i] = new int[]{startTime[i], endTime[i], profit[i]};
            }
            // endTime
            Arrays.sort(jobs, Comparator.comparingInt(a -> a[1]));
            int[] f = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int j = upper_bound(jobs, i, jobs[i][0]) - 1;
                f[i + 1] = Math.max(f[i], f[j + 1] + jobs[i][2]);
            }
            return f[n];
        }

        private int upper_bound(int[][] jobs, int right, int endTime) {
            int l = 0, r = right + 1;
            while (l < r) {
                int mid = l + (r - l) / 2;
                if (jobs[mid][1] <= endTime) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l;
        }
    }
}