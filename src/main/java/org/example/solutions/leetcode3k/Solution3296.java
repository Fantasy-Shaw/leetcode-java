package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3296 {
    class Solution {
        public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
            PriorityQueue<long[]> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));
            for (int t : workerTimes) {
                pq.offer(new long[] {t, t, t});
            }
            long ans = 0;
            while (mountainHeight-- > 0) {
                var cur = pq.poll();
                ans = Math.max(ans, cur[0]);
                cur[0] += cur[1] + cur[2];
                cur[1] += cur[2];
                pq.offer(cur);
            }
            return ans;
        }
    }
}
