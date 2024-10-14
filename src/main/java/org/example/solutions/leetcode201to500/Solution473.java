package org.example.solutions.leetcode201to500;

import java.util.Arrays;

public class Solution473 {
    class Solution {
        public boolean makesquare(int[] matchsticks) {
            int sum = Arrays.stream(matchsticks).sum();
            if (matchsticks.length < 4 || sum % 4 != 0) {
                return false;
            }
            Arrays.sort(matchsticks);
            int[] cur = new int[4];
            return dfs(matchsticks, matchsticks.length - 1, cur, sum / 4);
        }

        private boolean dfs(int[] matchsticks, int x, int[] cur, int edge) {
            if (x == -1) {
                return true;
            }
            check:
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < i; j++) {
                    if (cur[i] == cur[j]) {
                        continue check;
                    }
                }
                int u = matchsticks[x];
                if (cur[i] + u > edge) {
                    continue;
                }
                cur[i] += u;
                if (dfs(matchsticks, x - 1, cur, edge)) {
                    return true;
                }
                cur[i] -= u;
            }
            return false;
        }
    }
}