package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1046 {
    class Solution {
        public int lastStoneWeight(int[] stones) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
            for (int s : stones) {
                pq.add(s);
            }
            while (pq.size() > 1) {
                pq.offer(Math.abs(pq.poll() - pq.poll()));
            }
            return pq.peek();
        }
    }
}