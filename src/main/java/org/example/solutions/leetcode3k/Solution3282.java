package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3282 {
    class Solution {
        public long findMaximumScore(List<Integer> nums) {
            int[] x = nums.stream().mapToInt(i -> i).toArray();
            long ans = 0;
            int i = 0;
            for (int j = 1; j < x.length; j++) {
                if (x[j] > x[i]) {
                    ans += (long) (j - i) * x[i];
                    i = j;
                }
            }
            int j = x.length - 1;
            if (i != j) {
                ans += (long) (j - i) * x[i];
            }
            return ans;
        }
    }
}