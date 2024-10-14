package org.example.solutions.leetcode3k;

import java.util.HashMap;
import java.util.Map;

public class Solution3137 {
    class Solution {
        public int minimumOperationsToMakeKPeriodic(String word, int k) {
            Map<String, Integer> map = new HashMap<>();
            for (int i = 0; i <= word.length() - k; i += k) {
                String cur = word.substring(i, i + k);
                map.merge(cur, 1, Integer::sum);
            }
            int mx = -1;
            for (var p : map.entrySet()) {
                mx = Math.max(mx, p.getValue());
            }
            return word.length() / k - mx;
        }
    }
}