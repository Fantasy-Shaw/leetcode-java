package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3075 {
    class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            List<Long> hap = new ArrayList<>();
            for (int h : happiness) {
                hap.add((long) h);
            }
            hap.sort(Collections.reverseOrder());
            long ans = 0;
            for (int i = 0; i < k; i++) {
                ans += Math.max(0, hap.get(i) - i);
            }
            return ans;
        }
    }
}