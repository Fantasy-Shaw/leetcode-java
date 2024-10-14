package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution3264 {
    class Solution {
        public int[] getFinalState(int[] nums, int k, int multiplier) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            for (int i = 0; i < nums.length; i++) {
                pq.offer(new int[]{i, nums[i]});
            }
            for (int i = 0; i < k; i++) {
                var cur = pq.poll();
                cur[1] *= multiplier;
                pq.offer(cur);
            }
            List<int[]> ans = new ArrayList<>(pq);
            ans.sort(Comparator.comparingInt(a -> a[0]));
            return ans.stream().mapToInt(a -> a[1]).toArray();
        }
    }
}