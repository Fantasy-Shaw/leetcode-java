package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1723 {
    class Solution {
        public int minimumTimeRequired(int[] jobs, int k) {
            int n = jobs.length;
            int[] sum = new int[1 << n];
            for (int i = 0; i < n; i++) {
                for (int j = 0, bit = 1 << i; j < bit; j++) {
                    sum[bit | j] = sum[j] + jobs[i];
                }
            }
            int[] f = sum.clone();
            for (int i = 1; i < k; i++) {
                for (int j = (1 << n) - 1; j > 0; j--) {
                    for (int s = j; s > 0; s = (s - 1) & j) {
                        f[j] = Math.min(f[j], Math.max(f[j ^ s], sum[s]));
                    }
                }
            }
            return f[(1 << n) - 1];
        }
    }
}