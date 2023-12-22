package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2256 {
    class Solution {
        public int minimumAverageDifference(int[] nums) {
            int n = nums.length, res = 0;
            long min = Long.MAX_VALUE;
            long[] prefix = new long[n + 1];
            for (int i = 0; i < n; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
            for (int i = 0; i < n; i++) {
                long t1 = prefix[i + 1] / (i + 1);
                long t2 = (n - i - 1 == 0) ? 0 : (prefix[n] - prefix[i + 1])/ (n - i - 1);
                long diff = Math.abs(t1 - t2);
                if (diff < min) {
                    res = i;
                    min = diff;
                }
            }
            return res;
        }
    }
}