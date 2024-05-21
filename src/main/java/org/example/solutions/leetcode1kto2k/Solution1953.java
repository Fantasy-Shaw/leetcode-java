package org.example.solutions.leetcode1kto2k;

import java.util.*;

public class Solution1953 {
    class Solution {
        public long numberOfWeeks(int[] milestones) {
            long sum = 0;
            int mx = -1;
            for (int x : milestones) {
                sum += x;
                mx = Math.max(mx, x);
            }
            return mx > sum - mx + 1 ? (sum - mx) * 2 + 1 : sum;
        }
    }
}