package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2974 {
    class Solution {
        public int[] numberGame(int[] nums) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            List<Integer> ans = new ArrayList<>();
            for (int n : nums) {
                pq.offer(n);
            }
            while (pq.size() >= 2) {
                int alice = pq.poll(), bob = pq.poll();
                ans.add(bob);
                ans.add(alice);
            }
            return ans.stream().mapToInt(i -> i).toArray();
        }
    }
}