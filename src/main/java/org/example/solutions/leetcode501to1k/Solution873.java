package org.example.solutions.leetcode501to1k;

import java.util.HashMap;

public class Solution873 {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            HashMap<Integer, Integer> indices = new HashMap<>();
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                indices.put(arr[i], i);
            }
            int[][] dp = new int[n][n];
            int ans = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
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