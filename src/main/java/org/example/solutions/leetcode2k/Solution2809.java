package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2809 {
    class Solution {
        public int minimumTime(List<Integer> nums1, List<Integer> nums2, int x) {
            int n = nums1.size(), sum1 = 0, sum2 = 0;
            int[][] pairs = new int[n][2];
            for (int i = 0; i < n; i++) {
                int a = nums1.get(i), b = nums2.get(i);
                sum1 += a;
                sum2 += b;
                pairs[i][0] = a;
                pairs[i][1] = b;
            }
            Arrays.sort(pairs, Comparator.comparingInt(a -> a[1]));
            int[] f = new int[n + 1];
            for (int i = 0; i < n; i++) {
                int a = pairs[i][0], b = pairs[i][1];
                for (int j = i + 1; j > 0; j--) {
                    f[j] = Math.max(f[j], f[j - 1] + a + b * j);
                }
            }
            for (int t = 0; t <= n; t++) {
                if (sum1 + sum2 * t - f[t] <= x) {
                    return t;
                }
            }
            return -1;
        }
    }
}