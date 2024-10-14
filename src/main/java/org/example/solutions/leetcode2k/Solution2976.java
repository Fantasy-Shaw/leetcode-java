package org.example.solutions.leetcode2k;

import java.util.Arrays;

public class Solution2976 {
    class Solution {
        private static final long inf = Integer.MAX_VALUE;

        public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
            long[][] dis = new long[26][26];
            for (int i = 0; i < 26; i++) {
                Arrays.fill(dis[i], inf);
                dis[i][i] = 0;
            }
            int n = original.length;
            for (int i = 0; i < n; i++) {
                int x = original[i] - 'a', y = changed[i] - 'a';
                dis[x][y] = Math.min(dis[x][y], cost[i]);
            }
            for (int k = 0; k < 26; k++) {
                for (int i = 0; i < 26; i++) {
                    for (int j = 0; j < 26; j++) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
            long ans = 0;
            int m = source.length();
            for (int i = 0; i < m; i++) {
                long cur = dis[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
                if (cur == inf) return -1;
                ans += cur;
            }
            return ans;
        }
    }
}