package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution871 {
    class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            int n = stations.length, i = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
            int fuel = startFuel, pos = 0, ans = 0;
            while (pos < target) {
                if (fuel == 0) {
                    if (!pq.isEmpty()) {
                        fuel += pq.poll();
                        ans++;
                    } else {
                        return -1;
                    }
                }
                pos += fuel;
                fuel = 0;
                while (i < n && stations[i][0] <= pos) {
                    pq.offer(stations[i][1]);
                    i++;
                }
            }
            return ans;
        }
    }
}