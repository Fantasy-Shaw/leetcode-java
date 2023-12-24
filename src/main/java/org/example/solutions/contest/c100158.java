package org.example.solutions.contest;

import java.util.*;

public class c100158 {
    class Solution {
        private static final int mod = 99371, base = 29;
        private static final long inf = (long) 1e15;
        private long[][] dist;
        private long[] dp;
        private int[] map, originalHash, changedHash;
        private int tot;

        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            init();
            int n = original.length;
            for (int i = 0; i < n; i++) {
                originalHash[i] = getHash(original[i]);
                if (map[originalHash[i]] == 0) {
                    map[originalHash[i]] = ++tot;
                }
            }
            for (int i = 0; i < n; i++) {
                changedHash[i] = getHash(changed[i]);
                if (map[changedHash[i]] == 0) {
                    map[changedHash[i]] = ++tot;
                }
            }
            for (int i = 1; i <= tot; i++) {
                Arrays.fill(dist[i], inf);
            }
            for (int i = 0; i < n; i++) {
                int ids = map[originalHash[i]], ide = map[changedHash[i]];
                dist[ids][ide] = Math.min(cost[i], dist[ids][ide]);
            }
            for (int k = 1; k <= tot; k++) {
                for (int i = 1; i <= tot; i++) {
                    for (int j = 1; j <= tot; j++) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
            int m = source.length();
            char[] src = (" " + source).toCharArray(), dst = (" " + target).toCharArray();
            Arrays.fill(dp, inf);
            dp[0] = 0;
            for (int i = 0; i <= m; i++) {
                boolean flag = true;
                int tmpS = 0, tmpT = 0;
                for (int j = i + 1; j <= m; j++) {
                    if (src[j] != dst[j]) flag = false;
                    tmpS = tmpS * base % mod + (src[j] - 'a' + 1);
                    tmpS %= mod;
                    tmpT = tmpT * base % mod + (dst[j] - 'a' + 1);
                    tmpT %= mod;
                    if (flag) dp[j] = Math.min(dp[j], dp[i]);
                    int ids = map[tmpS], ide = map[tmpT];
                    if (ids > 0 && ide > 0) {
                        dp[j] = Math.min(dp[j], dp[i] + dist[ids][ide]);
                    }
                }
            }
            return dp[m] == inf ? -1 : dp[m];
        }

        private int getHash(String s) {
            int res = 0;
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                res = res * base % mod + (cs[i] - 'a' + 1);
                res %= mod;
            }
            return res;
        }

        private void init() {
            tot = 0;
            map = new int[(int) 1e5 + 2];
            originalHash = new int[101];
            changedHash = new int[101];
            dp = new long[1001];
            dist = new long[201][201];
        }
    }
}