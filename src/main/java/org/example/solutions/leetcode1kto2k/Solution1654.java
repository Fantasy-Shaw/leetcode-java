package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1654 {
    class Solution {
        int maxN = 6005;

        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            Set<Integer> forbiddenSet = new HashSet<>();
            for (int n : forbidden) {
                forbiddenSet.add(n);
            }
            // int[2] : (pos,isBackward)
            Queue<int[]> qu = new ArrayDeque<>();
            boolean[][] vis = new boolean[maxN][2];
            qu.offer(new int[]{0, 0});
            int ans = 0;
            while (!qu.isEmpty()) {
                int m = qu.size();
                for (int i = 0; i < m; i++) {
                    var p = qu.poll();
                    int pos = p[0], isBackward = p[1];
                    if (pos < 0 || pos >= maxN || forbiddenSet.contains(pos) || vis[pos][isBackward]) {
                        continue;
                    }
                    if (pos == x) {
                        return ans;
                    }
                    vis[pos][isBackward] = true;
                    qu.offer(new int[]{pos + a, 0});
                    if (isBackward == 0) {
                        qu.offer(new int[]{pos - b, 1});
                    }
                }
                ans++;
            }
            return -1;
        }
    }
}