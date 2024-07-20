package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution502 {
    class Solution {
        public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
            int n = profits.length;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int[][] cps = new int[n][2];
            for (int i = 0; i < n; i++) {
                cps[i][0] = capital[i];
                cps[i][1] = profits[i];
            }
            Arrays.sort(cps, (o1, o2) -> o1[0] - o2[0]);
            int cur = 0;
            for (int i = 0; i < k; i++) {
                while (cur < n && cps[cur][0] <= w) {
                    pq.offer(cps[cur][1]);
                    cur++;
                }
                if (!pq.isEmpty()) {
                    w += pq.poll();
                } else {
                    break;
                }
            }
            return w;
        }
    }
}