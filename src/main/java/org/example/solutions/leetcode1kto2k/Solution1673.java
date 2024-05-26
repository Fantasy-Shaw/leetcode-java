package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1673 {
    class Solution {
        public int[] mostCompetitive(int[] nums, int k) {
            int n = nums.length;
            List<int[]> ans = new ArrayList<>();
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
            for (int i = 0; i < n - k + 1; i++) {
                pq.offer(new int[]{i, nums[i]});
            }
            for (int i = 0; i < k; i++) {
                while (!ans.isEmpty() && pq.peek()[0] < ans.getLast()[0]) {
                    pq.poll();
                }
                ans.add(pq.poll());
                if (i < k - 1) {
                    pq.add(new int[]{n - k + i + 1, nums[n - k + i + 1]});
                }
            }
            return ans.stream().mapToInt(a -> a[1]).toArray();
        }
    }
}