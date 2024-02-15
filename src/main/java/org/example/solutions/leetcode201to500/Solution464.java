package org.example.solutions.leetcode201to500;

import java.util.*;

public class Solution464 {
    class Solution {
        public boolean canIWin(int mx, int target) {
            int mxSum = mx * (mx + 1) / 2;
            if (mxSum < target) {
                return false; // No one can win.
            }
            int[] memo = new int[1 << 21];
            Arrays.fill(memo, -1);
            return dfs(mx, target, 0, 0, memo);
        }

        private boolean dfs(int mx, int target, int sum, int st, int[] memo) {
            if (memo[st] != -1) {
                return memo[st] == 1;
            }
            if (sum >= target) {
                memo[st] = 1;
                return true;
            }
            for (int i = 1; i <= mx; i++) {
                if ((st >> i & 1) != 0) {
                    continue; // used
                }
                if (sum + i >= target) {
                    memo[st] = 1;
                    return true;
                }
                boolean rivalWin = dfs(mx, target, sum + i, st | (1 << i), memo);
                if (!rivalWin) {
                    memo[st] = 1;
                    return true;
                }
            }
            memo[st] = 0;
            return false;
        }
    }
}