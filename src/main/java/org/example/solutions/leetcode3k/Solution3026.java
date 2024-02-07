package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3026 {
    class Solution {
        long inf = Long.MAX_VALUE;

        public long maximumSubarraySum(int[] nums, int k) {
            long ans = Long.MIN_VALUE;
            long sum = 0;
            Map<Integer, Long> minS = new HashMap<>();
            for (int x : nums) {
                long s1 = minS.getOrDefault(x - k, inf);
                long s2 = minS.getOrDefault(x + k, inf);
                long s = Math.min(s1, s2);
                if (s != inf) {
                    ans = Math.max(ans, sum + x - s);
                }
                minS.merge(x, sum, Math::min);
                sum += x;
            }
            return ans > Long.MIN_VALUE ? ans : 0;
        }
    }
}