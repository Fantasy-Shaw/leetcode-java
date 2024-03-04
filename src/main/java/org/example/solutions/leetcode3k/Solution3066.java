package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3066 {
    /**
     * [1000000000,999999999,1000000000,999999999,1000000000,999999999]
     * 1000000000
     * 2
     */
    class Solution {
        public int minOperations(int[] nums, int k) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i : nums) {
                pq.add((long) i);
            }
            int ans = 0;
            while (pq.size() > 1 && pq.peek() < k) {
                ans++;
                long x = pq.poll();
                long y = pq.poll();
                long ne = Math.min(x, y) * 2 + Math.max(x, y);
                pq.offer(ne);
            }
            return ans;
        }
    }
}