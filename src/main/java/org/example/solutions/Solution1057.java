package org.example.solutions;

import java.util.*;

public class Solution1057 {
    class Solution {
        private int getDistance(int[] worker, int[] bike) {
            return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
        }

        public int[] assignBikes(int[][] workers, int[][] bikes) {
            int m = workers.length, n = bikes.length;
            int[] ans = new int[m];
            //int[3]: workerId bikeId distance
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
                if (a[2] != b[2]) { // distance
                    return a[2] - b[2];
                }
                if (a[0] != b[0]) { // workerId
                    return a[0] - b[0];
                }
                return a[1] - b[1]; // bikeId
            });

            boolean[] visWorker = new boolean[m], visBike = new boolean[n];
            int allocated_num = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    pq.offer(new int[]{i, j, getDistance(workers[i], bikes[j])});
                }
            }
            while (!pq.isEmpty() && allocated_num < m) {
                int[] t = pq.poll();
                if (!visWorker[t[0]] && !visBike[t[1]]) {
                    ans[t[0]] = t[1];
                    allocated_num++;
                    visWorker[t[0]] = true;
                    visBike[t[1]] = true;
                }
            }
            return ans;
        }
    }
}
