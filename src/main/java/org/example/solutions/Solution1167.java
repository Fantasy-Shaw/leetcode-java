package org.example.solutions;

import java.util.PriorityQueue;

public class Solution1167 {
    class Solution {
        public int connectSticks(int[] sticks) {
            if (sticks.length <= 1) {
                return 0;
            }
            int ans = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int n : sticks) {
                pq.offer(n);
            }
            while (pq.size() > 1) {
                int x = pq.poll();
                int y = pq.poll();
                pq.offer(x + y);
                ans += (x + y);
            }
            return ans;
        }
    }
}