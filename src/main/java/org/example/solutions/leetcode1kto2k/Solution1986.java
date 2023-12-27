package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1986 {
    class Solution {
        public int minSessions(int[] tasks, int sessionTime) {
            int n = tasks.length, m = 1 << n;
            int[] sum = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0, bit = 1 << i; j < bit; j++) {
                    sum[bit | j] = sum[j] + tasks[i];
                }
            }
            int[] f = new int[m];
            Arrays.fill(f, n);
            f[0] = 0;
            for (int s = 0; s < m; s++) {
                for (int sub = s; sub > 0; sub = (sub - 1) & s) {
                    if (sum[sub] <= sessionTime) {
                        f[s] = Math.min(f[s], f[s ^ sub] + 1);
                    }
                }
            }
            return f[m - 1];
        }
    }
}
