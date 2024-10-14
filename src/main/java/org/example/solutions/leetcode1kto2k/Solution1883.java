package org.example.solutions.leetcode1kto2k;

import java.util.Arrays;

public class Solution1883 {
    class Solution {
        int speed;

        public int minSkips(int[] dist, int speed, int hoursBefore) {
            this.speed = speed;
            long sum = 0;
            for (int d : dist) {
                sum += d;
            }
            if (sum > (long) speed * hoursBefore) {
                return -1;
            }
            int n = dist.length;
            long[][] memo = new long[n][n];
            for (var it : memo) {
                Arrays.fill(it, -1);
            }
            for (int skips = 0; skips <= n - 1; skips++) {
                if (dfs(dist, skips, n - 2, memo) + dist[n - 1] <= (long) speed * hoursBefore) {
                    return skips;
                }
            }
            return -1;
        }

        private long dfs(int[] dist, int skips, int pos, long[][] memo) {
            if (pos < 0) {
                return 0;
            }
            if (memo[skips][pos] != -1) {
                return memo[skips][pos];
            }
            long ans = dfs(dist, skips, pos - 1, memo) + dist[pos];
            ans = (ans % speed == 0) ? ans : (ans / speed + 1) * speed; // ceiling
            if (skips > 0) {
                ans = Math.min(ans, dfs(dist, skips - 1, pos - 1, memo) + dist[pos]);
            }
            memo[skips][pos] = ans;
            return ans;
        }
    }
}