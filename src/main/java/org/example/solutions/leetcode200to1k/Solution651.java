package org.example.solutions.leetcode200to1k;

public class Solution651 {
    class Solution {
        public int maxA(int n) {
            int[] best = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                best[i] = best[i - 1] + 1;
                for (int j = 0; j < i - 1; j++) {
                    best[i] = Math.max(best[i], best[j] * (i - j - 1));
                }
            }
            return best[n];
        }
    }
}