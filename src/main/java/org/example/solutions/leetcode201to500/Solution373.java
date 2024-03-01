package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution373 {
    class Solution {
        public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
            List<List<Integer>> ans = new ArrayList<>();
            for (int i = 0; i < Math.min(nums2.length, k); i++) {
                pq.add(new int[]{0, i});
            }
            while (k-- > 0 && !pq.isEmpty()) {
                var x = pq.poll();
                ans.add(List.of(nums1[x[0]], nums2[x[1]]));
                if (x[0] + 1 < nums1.length) {
                    pq.offer(new int[]{x[0] + 1, x[1]});
                }
            }
            return ans;
        }
    }
}