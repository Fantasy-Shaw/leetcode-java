package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2977 {
    class Solution {
        // Memo
        private Node root;
        private int sid;
        private char[] s, t;
        private int[][] dis;
        private long[] memo;

        public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
            sid = 0;
            root = new Node();
            int m = cost.length;
            dis = new int[m * 2][m * 2];
            for (int i = 0; i < dis.length; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE / 2);
                dis[i][i] = 0;
            }
            for (int i = 0; i < cost.length; i++) {
                int x = put(original[i]), y = put(changed[i]);
                dis[x][y] = Math.min(dis[x][y], cost[i]);
            }
            for (int k = 0; k < sid; k++) {
                for (int i = 0; i < sid; i++) {
                    if (dis[i][k] == Integer.MAX_VALUE / 2) {
                        continue;
                    }
                    for (int j = 0; j < sid; j++) {
                        dis[i][j] = Math.min(dis[i][j], dis[i][k] + dis[k][j]);
                    }
                }
            }
            s = source.toCharArray();
            t = target.toCharArray();
            memo = new long[s.length];
            Arrays.fill(memo, -1);
            long ans = dfs(0);
            return ans < Long.MAX_VALUE / 2 ? ans : -1;
        }

        private long dfs(int i) {
            if (i >= s.length) {
                return 0;
            }
            if (memo[i] != -1) {
                return memo[i];
            }
            long res = Long.MAX_VALUE / 2;
            if (s[i] == t[i]) {
                res = dfs(i + 1);
            }
            Node p = root, q = root;
            for (int j = i; j < s.length; j++) {
                p = p.son[s[j] - 'a'];
                q = q.son[t[j] - 'a'];
                if (p == null || q == null) {
                    break;
                }
                if (p.sid < 0 || q.sid < 0) {
                    continue;
                }
                int d = dis[p.sid][q.sid];
                if (d < Integer.MAX_VALUE / 2) {
                    res = Math.min(res, d + dfs(j + 1));
                }
            }
            memo[i] = res;
            return res;
        }

        private int put(String s) {
            Node o = root;
            for (char b : s.toCharArray()) {
                int i = b - 'a';
                if (o.son[i] == null) {
                    o.son[i] = new Node();
                }
                o = o.son[i];
            }
            if (o.sid < 0) o.sid = sid++;
            return o.sid;
        }

        private class Node {
            Node[] son = new Node[26];
            int sid = -1; // stringId
        }
    }

    class Solution1 {
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