package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2981And2982 {
    class Solution {
        public int maximumLength(String _s) {
            char[] s = _s.toCharArray();
            int n = s.length;
            Map<Integer, Integer>[] hashMaps = new Map[26];
            Arrays.setAll(hashMaps, k -> new HashMap<>());
            for (int i = 0, j = 0; i < n && j < n; ) {
                j = i + 1;
                while (j < n && s[j] == s[i]) {
                    j++;
                }
                for (int k = 0; k < j - i; k++) {
                    hashMaps[s[i] - 'a'].merge(j - i - k, k + 1, Integer::sum);
                }
                i = j;
            }
            int ans = -1;
            for (var map : hashMaps) {
                for (var p : map.entrySet()) {
                    if (p.getValue() >= 3 && p.getKey() > ans) {
                        ans = p.getKey();
                    }
                }
            }
            return ans;
        }
    }
}