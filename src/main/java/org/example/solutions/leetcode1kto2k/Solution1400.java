package org.example.solutions.leetcode1kto2k;

import java.util.HashMap;
import java.util.Map;

public class Solution1400 {
    class Solution {
        public boolean canConstruct(String s, int k) {
            if (k > s.length()) {
                return false;
            }
            int n_odd = 0;
            Map<Character, Integer> map = new HashMap<>();
            for (char ch : s.toCharArray()) {
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
            for (var kv : map.entrySet()) {
                int i = kv.getValue();
                if (i % 2 == 1) {
                    n_odd++;
                }
            }
            return n_odd <= k;
        }
    }
}