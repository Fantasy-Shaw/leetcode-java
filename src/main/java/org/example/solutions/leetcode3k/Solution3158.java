package org.example.solutions.leetcode3k;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3158 {
    class Solution {
        public int duplicateNumbersXOR(int[] nums) {
            Map<Integer, Integer> cnt = new HashMap<>();
            for (int x : nums) {
                cnt.merge(x, 1, Integer::sum);
            }
            List<Integer> target = new ArrayList<>();
            for (var p : cnt.entrySet()) {
                if (p.getValue().equals(2)) {
                    target.add(p.getKey());
                }
            }
            if (target.isEmpty()) {
                return 0;
            }
            int ans = target.getFirst();
            for (int i = 1; i < target.size(); i++) {
                ans ^= target.get(i);
            }
            return ans;
        }
    }
}