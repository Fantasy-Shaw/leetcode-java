package org.example.solutions.leetcode501to1k;

import java.util.*;

public class Solution838 {
    class Solution {
        static final int L = -1, R = 1;

        public String pushDominoes(String dominoes) {
            char[] ans = dominoes.toCharArray();
            int n = ans.length;
            int[] forcedTime = new int[n];
            Queue<int[]> qu = new ArrayDeque<>();
            for (int i = 0; i < n; i++) {
                if (ans[i] == '.') {
                    continue;
                }
                qu.offer(new int[]{i, 1, (ans[i] == 'L' ? L : R)});
                forcedTime[i] = 1;
            }
            while (!qu.isEmpty()) {
                var t = qu.poll();
                int i = t[0], time = t[1], dir = t[2];
                int j = i + dir;
                if ((j < 0 || j >= n) || ans[i] == '.') {
                    continue;
                }
                if (forcedTime[j] == 0) {
                    qu.offer(new int[]{j, time + 1, dir});
                    forcedTime[j] = time + 1;
                    ans[j] = (dir == L ? 'L' : 'R');
                } else if (forcedTime[j] == time + 1) {
                    ans[j] = '.';
                }
            }
            return new String(ans);
        }
    }
}