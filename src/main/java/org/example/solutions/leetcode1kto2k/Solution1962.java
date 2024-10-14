package org.example.solutions.leetcode1kto2k;

import java.util.PriorityQueue;

public class Solution1962 {
    class Solution {
        public int minStoneSum(int[] piles, int k) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            int ans = 0;
            for (int n : piles) {
                ans += n;
                pq.offer(n);
            }
            while (!pq.isEmpty() && k-- > 0) {
                int cur = pq.poll();
                ans -= cur / 2;
                pq.offer(cur - cur / 2);
            }
            return ans;
        }
    }
}