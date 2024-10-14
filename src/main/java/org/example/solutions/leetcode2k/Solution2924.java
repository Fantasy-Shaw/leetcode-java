package org.example.solutions.leetcode2k;

public class Solution2924 {
    class Solution {
        public int findChampion(int n, int[][] edges) {
            int cnt = 0, ans = -1;
            int[] strongers = new int[n];
            for (var e : edges) {
                strongers[e[1]]++;
            }
            for (int i = 0; i < n; i++) {
                if (strongers[i] == 0) {
                    if (++cnt > 1) {
                        return -1;
                    }
                    ans = i;
                }
            }
            return ans;
        }
    }
}