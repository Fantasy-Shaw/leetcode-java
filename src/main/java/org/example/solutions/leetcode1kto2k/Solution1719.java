package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1719 {
    class Solution {
        private final int n = 501;
        private int[] cnts, fa;
        private boolean[][] g;

        public int checkWays(int[][] pairs) {
            cnts = new int[n];
            fa = new int[n];
            g = new boolean[n][n];
            int m = pairs.length;
            Set<Integer> set = new HashSet<>();
            for (var p : pairs) {
                int a = p[0], b = p[1];
                g[a][b] = g[b][a] = true;
                cnts[a]++;
                cnts[b]++;
                set.add(a);
                set.add(b);
            }
            List<Integer> list = new ArrayList<>(set);
            list.sort(Comparator.comparingInt(value -> -cnts[value]));
            int n = list.size(), root = list.get(0);
            if (m < n - 1) {
                return 0; // Forest
            }
            fa[root] = -1;
            for (int i = 1; i < n; i++) {
                int a = list.get(i);
                boolean ok = false;
                for (int j = i - 1; j >= 0 && !ok; j--) {
                    int b = list.get(j);
                    if (g[a][b]) {
                        fa[a] = b;
                        ok = true;
                    }
                }
                if (!ok) {
                    return 0;
                }
            }
            int c = 0, ans = 1;
            for (int i : set) {
                int j = i;
                while (fa[j] != -1) {
                    if (!g[i][fa[j]]) return 0;
                    if (cnts[i] == cnts[fa[j]]) ans = 2;
                    c++;
                    j = fa[j];
                }
            }
            return c < m ? 0 : ans;
        }
    }
}