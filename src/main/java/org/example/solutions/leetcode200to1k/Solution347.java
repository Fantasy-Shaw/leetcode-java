package org.example.solutions.leetcode200to1k;

import java.util.*;

public class Solution347 {
    class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i : nums) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(value -> -value[1]));
            for (var pair : map.entrySet()) {
                pq.offer(new int[]{pair.getKey(), pair.getValue()});
            }
            List<Integer> ans = new ArrayList<>();
            while (!pq.isEmpty() && k-- > 0) {
                ans.add(pq.poll()[0]);
            }
            return ans.stream().mapToInt(i -> i).toArray();
        }
    }
}