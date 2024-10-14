package org.example.solutions.leetcode3k;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution3009 {
    class Solution {
        static final int MIN = 0, MAX = 1;

        public int maxIntersectionCount(int[] y) { //扫描线
            int n = y.length;
            PriorityQueue<int[]> pq = new PriorityQueue<>(
                    (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
            );
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < n - 1; i++) {
                int left = y[i], right = y[i + 1], mn, mx;
                if (left > right) {
                    mx = left * 2;
                    mn = right * 2 + (i == n - 2 ? 0 : 1);
                } else {
                    mn = left * 2;
                    mx = right * 2 - (i == n - 2 ? 0 : 1);
                }
                pq.offer(new int[]{mn, MIN, i});
                pq.offer(new int[]{mx, MAX, i});
            }
            int ans = 0;
            while (!pq.isEmpty()) {
                int[] cur = pq.peek();
                while (!pq.isEmpty() && pq.peek()[0] == cur[0] && pq.peek()[1] == MIN) {
                    set.add(pq.poll()[2]);
                }
                ans = Math.max(ans, set.size());
                while (!pq.isEmpty() && pq.peek()[0] == cur[0] && pq.peek()[1] == MAX) {
                    set.remove(pq.poll()[2]);
                }
            }
            return ans;
        }
    }
}