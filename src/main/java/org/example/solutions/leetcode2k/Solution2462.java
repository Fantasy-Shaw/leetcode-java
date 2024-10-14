package org.example.solutions.leetcode2k;

import java.util.PriorityQueue;

public class Solution2462 {
    class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            long ans = 0;
            int n = costs.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            int l = 0, r = n - 1;
            for (; l < Math.min(n, candidates); l++) {
                pq.offer(new int[]{costs[l], l});
            }
            for (; r >= l && r >= n - candidates; r--) {
                pq.offer(new int[]{costs[r], r});
            }
            while (k-- > 0) {
                var x = pq.poll();
                ans += x[0];
                if (l <= r) {
                    if (x[1] < l) {
                        pq.offer(new int[]{costs[l], l++});
                    } else {
                        pq.offer(new int[]{costs[r], r--});
                    }
                }
            }
            return ans;
        }
    }
}