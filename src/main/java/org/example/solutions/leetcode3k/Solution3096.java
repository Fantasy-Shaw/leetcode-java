package org.example.solutions.leetcode3k;

public class Solution3096 {
    class Solution {
        public int minimumLevels(int[] possible) {
            int n = possible.length;
            int[] sum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sum[i] + (possible[i] == 0 ? -1 : 1);
            }
            int s = 0;
            for (int i = 0; i < n; i++) {
                s += (possible[i] == 0 ? -1 : 1);
            }
            for (int i = 0; i < n - 1; i++) {
                if (sum[i + 1] > s - sum[i + 1]) {
                    return i + 1;
                }
            }
            return -1;
        }
    }
}