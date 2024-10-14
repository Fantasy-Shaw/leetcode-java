package org.example.solutions.leetcode501to1k;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution857 {
    class Solution {
        public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
            int n = quality.length;
            Integer[] ids = new Integer[n];
            Arrays.setAll(ids, i -> i);
            Arrays.sort(ids, Comparator.comparingDouble(i -> (double) wage[i] / quality[i]));
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int sumQuality = 0;
            for (int i = 0; i < k; i++) {
                sumQuality += quality[ids[i]];
                pq.offer(quality[ids[i]]);
            }
            double ans = sumQuality * ((double) wage[ids[k - 1]] / quality[ids[k - 1]]);
            for (int i = k; i < n; i++) {
                int q = quality[ids[i]];
                if (q < pq.peek()) {
                    sumQuality -= pq.poll() - q;
                    pq.offer(q);
                    ans = Math.min(ans, sumQuality * ((double) wage[ids[i]] / q));
                }
            }
            return ans;
        }
    }
}