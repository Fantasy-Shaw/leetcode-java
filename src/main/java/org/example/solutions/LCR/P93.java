package org.example.solutions.LCR;

import java.util.*;

public class P93 {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int n = arr.length;
            Map<Integer, Integer> indices = new HashMap<>();
            for (int i = 0; i < n; i++) {
                indices.put(arr[i], i);
            }
            int[][] dp = new int[n][n];
            int ans = 0;
            for (int i = 0; i < n; i++) { // 3rd
                for (int j = 0; j < i; j++) { // 2nd
                    int first = arr[i] - arr[j];
                    int k = indices.getOrDefault(first, n);
                    if (k < j) {
                        dp[j][i] = Math.max(dp[k][j] + 1, 3);
                        ans = Math.max(ans, dp[j][i]);
                    }
                }
            }
            return ans;
        }
    }
}