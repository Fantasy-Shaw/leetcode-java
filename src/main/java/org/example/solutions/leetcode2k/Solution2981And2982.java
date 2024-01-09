package org.example.solutions.leetcode2k;

import java.util.*;

public class Solution2981And2982 {
    class Solution {
        public int maximumLength(String s) {
            char[] cs = s.toCharArray();
            List<List<Integer>> groups = new ArrayList<>();
            for (int i = 0; i < 26; i++) {
                groups.add(new ArrayList<>());
            }
            int cnt = 0;
            for (int i = 0; i < cs.length; i++) {
                cnt++;
                if (i == cs.length - 1 || cs[i] != cs[i + 1]) {
                    groups.get(cs[i] - 'a').add(cnt);
                    cnt = 0;
                }
            }
            int ans = 0;
            for (var a : groups) {
                if (a.isEmpty()) continue;
                a.sort(Collections.reverseOrder());
                a.add(0);
                a.add(0);
                int x0 = a.get(0), x1 = a.get(1), x2 = a.get(2);
                ans = Math.max(ans, Math.max(x0 - 2, Math.max(Math.min(x0 - 1, x1), x2)));
            }
            return ans > 0 ? ans : -1;
        }
    }
}