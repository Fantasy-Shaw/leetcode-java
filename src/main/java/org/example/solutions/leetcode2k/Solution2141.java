package org.example.solutions.leetcode2k;

import java.util.Arrays;

public class Solution2141 {
    class Solution {
        public long maxRunTime(int n, int[] batteries) {
            Arrays.sort(batteries);
            long l = 0, r = 0;
            for (int x : batteries) {
                r += x;
            }
            r += 1;
            while (l < r) {
                long mid = l + (r - l) / 2;
                if (isValid(batteries, mid, n)) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            return l - 1;
        }

        private boolean isValid(int[] batteries, long time, int n) {
            long sum = 0;
            for (int x : batteries) {
                sum += Math.min(time, x);
            }
            return n * time <= sum;
        }
    }
}