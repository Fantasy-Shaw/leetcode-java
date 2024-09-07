package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2708 {
    class Solution {
        public long maxStrength(int[] nums) {
            boolean zero = false;
            List<Integer> pos = new ArrayList<>();
            List<Integer> neg = new ArrayList<>();
            for (int x : nums) {
                if (x == 0) zero = true;
                else if (x > 0) pos.add(x);
                else neg.add(x);
            }
            Collections.sort(pos);
            Collections.sort(neg);
            long ans = 1;
            if (pos.isEmpty() && neg.size() <= 1) {
                return zero ? 0 : neg.getLast();
            }
            for (int x : pos) {
                ans *= x;
            }
            for (int i = 0; i < neg.size() / 2 * 2; i++) {
                ans *= neg.get(i);
            }
            return ans;
        }
    }
}