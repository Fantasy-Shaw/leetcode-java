package org.example.solutions.leetcode2k;

public class Solution2101 {
    class Solution {
        public int maximumDetonation(int[][] bombs) {
            int n = bombs.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                boolean[] vis = new boolean[n];
                vis[i] = true;
                ans = Math.max(ans, 1 + dfs(i, bombs, vis));
            }
            return ans;
        }

        private int dfs(int i, int[][] bombs, boolean[] vis) {
            int ans = 0;
            for (int x = 0; x < bombs.length; x++) {
                if (!vis[x] && canFire(bombs[i], bombs[x])) {
                    vis[x] = true;
                    ans += 1 + dfs(x, bombs, vis);
                }
            }
            return ans;
        }

        private boolean canFire(int[] src, int[] dst) {
            long d = (long) (src[0] - dst[0]) * (src[0] - dst[0]) + (long) (src[1] - dst[1]) * (src[1] - dst[1]);
            return d <= (long) src[2] * src[2];
        }
    }
}