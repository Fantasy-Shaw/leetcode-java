package org.example.solutions.leetcode3k;

import java.util.*;

public class Solution3014 {
    class Solution {
        public int minimumPushes(String word) {
            int n = word.length();
            int cur = 1;
            HashMap<Character, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                if (map.containsKey(ch)) {
                    ans += map.get(ch);
                } else {
                    ans += cur;
                    map.put(ch, cur);
                    if (map.size() % 8 == 0) {
                        cur++;
                    }
                }
            }
            return ans;
        }
    }
}