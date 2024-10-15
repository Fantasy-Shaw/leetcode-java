package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution658 {
    static
    class Solution {
        public List<Integer> findClosestElements(int[] arr, int k, int x) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
                int a1 = Math.abs(a - x), b1 = Math.abs(b - x);
                return a1 == b1 ? b - a : b1 - a1;
            });
            Arrays.stream(arr).forEach(i -> {
                pq.offer(i);
                if (pq.size() > k) {
                    pq.poll();
                }
            });
            return pq.stream().sorted(Comparator.naturalOrder()).toList();
        }
    }
}
