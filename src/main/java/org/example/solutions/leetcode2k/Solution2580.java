package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2580 {
    class Solution {
        static final int mod = (int) 1e9 + 7;

        public int countWays(int[][] ranges) {
            Arrays.sort(ranges, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            // merge intervals
            List<int[]> list = new ArrayList<>();
            for (var r : ranges) {
                if (!list.isEmpty() && list.getLast()[1] >= r[0]) {
                    var pre = list.removeLast();
                    list.add(new int[]{pre[0], Math.max(pre[1], r[1])});
                } else {
                    list.add(r);
                }
            }
            int m = list.size();
            // m segments divided into 2 buckets, w/o order
            return (int) quick_pow(2, m);
        }

        private static long quick_pow(long x, long n) {
            long ans = 1;
            for (; n > 0; n /= 2) {
                if (n % 2 == 1) {
                    ans = ans * x % mod;
                }
                x = x * x % mod;
            }
            return ans;
        }
    }
}